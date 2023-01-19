package com.programmersbox.common

import android.app.NotificationManager
import android.content.Context
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.until

public actual fun getPlatformName(): String {
    return "Android"
}

@Composable
public fun UIShow() {
    val context = LocalContext.current
    App(
        driverFactory = remember { DriverFactory(context) },
        appActions = AppActions(),
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