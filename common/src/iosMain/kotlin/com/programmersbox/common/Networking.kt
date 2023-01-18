package com.programmersbox.common

import kotlin.text.*
import io.ktor.client.request.*

internal actual fun toGameInfo(html: String): List<GameInfo> {
    val tableRegex = Regex("<table id=\"runTable\" class=\"table table-condensed\">([\\S\\s]*?)<\\/table>")
    val table = tableRegex.find(html)?.groupValues?.lastOrNull()
    val rowRegex = Regex("<tr>([\\S\\s]*?)<\\/tr>([\\S\\s]*?)<tr class=\\\"second-row \\\">([\\S\\s]*?)<\\/tr>")
    val row = rowRegex.findAll(table.toString())
        .flatMap {
            val groupValues = it.groupValues
            val game = groupValues.getOrNull(1)
            val info = groupValues.getOrNull(3)
            listOfNotNull(game, info)
        }
        .toList()
    val gameGameRegex = Regex("<td>(.*?)<\\/td>")
    val gameStartTimeRegex = Regex("<td class=\"start-time text-right\">(.*?)<\\/td>")
    val infoStartTimeRegex = Regex("<td class=\"text-right \">(.*?)(<i(.*?)<\\/i>)(.*?)<\\/td>")
    return row.mapIndexedNotNull { index, g ->
        try {
            if (index % 2 == 0) {
                val game = gameGameRegex.findAll(g).toList()
                val time = gameStartTimeRegex.find(g)?.groups?.get(1)?.value
                GameInfo.Game(
                    game = game.first().groups[1]?.value.orEmpty(),
                    runner = game.last().groups[1]?.value.orEmpty(),
                    startTime = time.orEmpty()
                )
            } else {
                val game = gameGameRegex.findAll(g).toList()
                val time = infoStartTimeRegex.find(g)?.groups
                GameInfo.Info(
                    time = time?.lastOrNull()?.value?.trim().orEmpty(),
                    info = game.first().groups[1]?.value.orEmpty()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

internal actual fun HttpRequestBuilder.clientBuild() {}