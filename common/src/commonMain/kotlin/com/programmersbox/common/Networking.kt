package com.programmersbox.common

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
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

internal sealed class GameInfo {
    data class Game(
        val game: String,
        val runner: String,
        val startTime: String
    ) : GameInfo()

    data class Info(
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

}

internal class GameViewModel {

    var gameInfo by mutableStateOf(emptyList<FullGameInfo>())

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

    suspend fun init() {
        gameInfo = Networking.getInfo()
    }

}

internal expect fun toGameInfo(html: String): List<GameInfo>

internal expect fun HttpRequestBuilder.clientBuild()
