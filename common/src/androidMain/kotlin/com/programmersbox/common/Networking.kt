package com.programmersbox.common

import io.ktor.client.request.*
import org.jsoup.Jsoup

internal actual fun toGameInfo(html: String): List<GameInfo> {
    return Jsoup.parse(html)
        .select("table#runTable")
        .select("tr, tr.second-row")
        .drop(1)
        .mapIndexedNotNull { index, g ->
            try {
                if (index % 2 == 0) {
                    GameInfo.Game(
                        game = g.select("tr > td")[1].text(),
                        runner = g.select("tr > td")[2].text(),
                        startTime = g.select("tr > td.start-time").text()
                    )
                } else {
                    GameInfo.Info(
                        time = g.select("tr.second-row > td.text-right").text(),
                        info = g.select("tr.second-row > td")[1].text()
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
}

internal actual fun HttpRequestBuilder.clientBuild() {}
