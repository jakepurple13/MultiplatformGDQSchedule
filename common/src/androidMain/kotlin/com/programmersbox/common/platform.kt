package com.programmersbox.common

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.datetime.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

public actual fun getPlatformName(): String {
    return "Android"
}

@Composable
public fun UIShow() {
    val context = LocalContext.current
    val alarm = remember { AndroidAlarmScheduler(context) }
    App(
        driverFactory = remember { DriverFactory(context) },
        appActions = AppActions(
            onSaveReminder = {
                alarm.schedule(
                    AlarmItem(
                        time = it.startTimeAsDate?.toLocalDateTime(TimeZone.currentSystemDefault())!!,
                        id = it.id.hashCode(),
                        game = it.game,
                        runner = it.runner,
                        startTime = it.startTimeReadable,
                        duration = it.time,
                        info = it.info
                    )
                )
            },
            onDeleteReminder = {
                alarm.cancel(
                    AlarmItem(
                        time = it.startTimeAsDate?.toLocalDateTime(TimeZone.currentSystemDefault())!!,
                        id = it.id.hashCode(),
                        game = it.game,
                        runner = it.runner,
                        startTime = it.startTimeReadable,
                        duration = it.time,
                        info = it.info
                    )
                )
            }
        ),
    )
}

@Composable
internal actual fun BoxScope.ScrollBar(state: LazyListState) {
}

internal class GameNotifier(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        val name = inputData.getString("gameName")
        val time = inputData.getString("gameTime")
        val info = inputData.getString("gameInfo")
        val id = inputData.getInt("gameId", 0)

        val n = NotificationCompat.Builder(applicationContext, "gdqschedule")
            .setSmallIcon(android.R.mipmap.sym_def_app_icon)
            .setContentTitle(name)
            .setContentText(time)
            .setContentInfo(info)
            .build()

        applicationContext.getSystemService<NotificationManager>()?.notify(id, n)

        return Result.success()
    }
}

internal class CurrentGameNotifier(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        val currentTime = Clock.System.now()

        val data = Networking.getInfo().orEmpty()

        var gameInfo: FullGameInfo? = null
        var index = 0

        for (i in data.withIndex()) {
            val it = i.value
            if (
                it.startTimeAsDate?.let { it1 -> currentTime.until(it1, DateTimeUnit.MILLISECOND) > 0 } == true &&
                data.getOrNull(i.index + 1)?.startTimeAsDate
                    ?.let { it1 -> currentTime.until(it1, DateTimeUnit.MILLISECOND) < 0 } == true
            ) {
                gameInfo = it
                index = i.index
                break
            }
        }

        val name = gameInfo?.game
        val time = gameInfo?.startTimeReadable
        val info = gameInfo?.info

        val next = data.getOrNull(index + 1)
        val second = data.getOrNull(index + 2)
        val third = data.getOrNull(index + 3)

        val n = NotificationCompat.Builder(applicationContext, "gdqschedule")
            //.setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(name)
            .setContentText(time)
            .setContentInfo(info)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .setBigContentTitle("$time - $name")
                    .setSummaryText("$time - $name")
                    .bigText(
                        listOf(
                            "${next?.startTimeReadable} - ${next?.game}",
                            "${second?.startTimeReadable} - ${second?.game}",
                            "${third?.startTimeReadable} - ${third?.game}"
                        )
                            .joinToString("\n")
                    )
            )
            .setOngoing(true)
            .build()

        applicationContext.getSystemService<NotificationManager>()?.notify(13, n)

        return Result.success()
    }
}

public class AndroidAlarmScheduler(
    private val context: Context
) {

    private val alarmManager by lazy { context.getSystemService(AlarmManager::class.java) }

    public fun schedule(item: AlarmItem) {
        val intent = Intent(
            context,
            AlarmReceiver::class.java
        ).apply {
            putExtra("AlarmItem", Json.encodeToString(item))
        }
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            item.time.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds(),
            PendingIntent.getBroadcast(
                context,
                item.id,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        )
    }

    public fun cancel(item: AlarmItem) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                item.id,
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        )
    }
}

public class AlarmReceiver : BroadcastReceiver() {
    public companion object {
        public val TAG: String = AlarmReceiver::class.simpleName.toString()
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val item = intent?.getStringExtra("AlarmItem")?.let { Json.decodeFromString<AlarmItem>(it) } ?: return
        val name = item.game.orEmpty()
        val time = item.startTime.orEmpty()
        val info = item.info.orEmpty()
        val id = item.id

        val n = context?.let {
            NotificationCompat.Builder(it, "gdqschedule")
                .setSmallIcon(android.R.mipmap.sym_def_app_icon)
                .setContentTitle(name)
                .setContentText(time)
                .setContentInfo(info)
                .build()
        }

        context?.getSystemService<NotificationManager>()?.notify(id, n)
    }

}

@Serializable
public data class AlarmItem(
    val time: LocalDateTime,
    val id: Int,
    val game: String? = "",
    val runner: String? = "",
    val startTime: String?,
    val duration: String? = null,
    val info: String? = null
)