package com.programmersbox.common

import io.ktor.client.request.*

internal actual fun toGameInfo(html: String): List<GameInfo> {
    return InfoStuff.setup(html).filterNotNull()
}

internal actual fun HttpRequestBuilder.clientBuild() {}