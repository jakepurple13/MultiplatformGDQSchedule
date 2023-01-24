package com.programmersbox.common

import androidx.compose.runtime.*
import com.programmersbox.reminders.RemindersQueries
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal object Networking {
    internal const val url = "https://gamesdonequick.com/schedule"

    private val client = HttpClient {

    }

    suspend fun getInfo(): List<FullGameInfo> {
        val html = gdqSource//client.get(url) { clientBuild() }.bodyAsText()
        return toGameInfo(html)
            .fold(mutableListOf<FullGameInfo>()) { m, i ->
                val f = when (i) {
                    is GameInfo.Game -> FullGameInfo(i.game, i.runner, i.startTime)
                    is GameInfo.Info -> {
                        val g = m.removeLastOrNull()
                        g?.copy(time = i.time, info = i.info)
                    }
                }
                f?.let { it1 -> m.add(it1) }
                m
            }
    }
}

public sealed class GameInfo {
    public data class Game(
        val game: String,
        val runner: String,
        val startTime: String
    ) : GameInfo()

    public data class Info(
        val time: String,
        val info: String
    ) : GameInfo()
}

internal data class FullGameInfo(
    val game: String?,
    val runner: String?,
    val startTime: String?,
    val time: String? = null,
    val info: String? = null
) {
    val startTimeReadable: String?
        get() {
            return startTime?.let { Instant.parse(it) }
                ?.toLocalDateTime(TimeZone.currentSystemDefault())
                ?.let { "${it.hour}:${it.minute}" }
        }

    val startTimeAsDate: Instant?
        get() {
            return startTime?.let { Instant.parse(it) }
        }

    val id = "$game-$runner"

}

internal class GameViewModel(
    driverFactory: DriverFactory,
    scope: CoroutineScope,
    private val appActions: AppActions
) {

    private var gameInfo by mutableStateOf(emptyList<FullGameInfo>())

    //val dateFormat = SimpleDateFormat("MMM d", Locale.getDefault())

    fun dateFormat(instant: Instant) = instant.toLocalDateTime(TimeZone.UTC).let { "${it.month} ${it.dayOfMonth}" }

    val gameInfoGrouped by derivedStateOf {
        gameInfo.groupBy { info ->
            info.startTime
                ?.let { it1 -> Instant.parse(it1) }
                ?.toLocalDateTime(TimeZone.UTC)
                ?.let { "${it.month} ${it.dayOfMonth}" }
                .toString()
        }
    }

    private lateinit var database: RemindersQueries

    //private val database by lazy { createDatabase(driverFactory).remindersQueries }
    /*val reminders by lazy {
        database.getReminders()
            .asFlow()
            .mapToList()
            .map { list ->
                list
                    .map { gameInfo ->
                        FullGameInfo(
                            game = gameInfo.game,
                            runner = gameInfo.runner,
                            startTime = Clock.System.now().toString(),//gameInfo.startTime,
                            time = gameInfo.time,
                            info = gameInfo.info
                        )
                    }
                    .sortedBy { it.startTimeAsDate }
            }
    }*/
    val reminders = mutableStateListOf<FullGameInfo>()

    init {
        scope.launch { gameInfo = Networking.getInfo() }

        scope.launch {
            database = async { createDatabase(driverFactory).remindersQueries }.await()

            database.getReminders()
                .asFlow()
                .mapToList()
                .map { list ->
                    list
                        .map { gameInfo ->
                            FullGameInfo(
                                game = gameInfo.game,
                                runner = gameInfo.runner,
                                startTime = gameInfo.startTime,
                                time = gameInfo.time,
                                info = gameInfo.info
                            )
                        }
                        .sortedBy { it.startTimeAsDate }
                }
                .onEach {
                    reminders.clear()
                    reminders.addAll(it)
                }
                .launchIn(scope)
        }
    }

    fun addReminder(gameInfo: FullGameInfo) {
        database.addReminder(
            id = gameInfo.id,
            game = gameInfo.game,
            runner = gameInfo.runner,
            startTime = gameInfo.startTime,
            time = gameInfo.time,
            info = gameInfo.info
        )
        appActions.onSaveReminder(gameInfo)
    }

    fun deleteReminder(gameInfo: FullGameInfo) {
        database.deleteReminder(gameInfo.id)
        appActions.onDeleteReminder(gameInfo)
    }

    fun updateReminder(gameInfo: FullGameInfo) {

    }

}

internal expect fun toGameInfo(html: String): List<GameInfo>

internal expect fun HttpRequestBuilder.clientBuild()
