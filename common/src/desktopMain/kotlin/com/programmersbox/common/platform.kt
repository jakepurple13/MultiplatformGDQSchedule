package com.programmersbox.common

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Notification
import androidx.compose.ui.window.TrayState

public actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
public fun UIShow(trayState: TrayState) {
    App(
        driverFactory = remember { DriverFactory() },
        appActions = AppActions(
            onSaveToNotify = {
                trayState.sendNotification(
                    Notification(
                        it.game.orEmpty(),
                        "${it.info} - ${it.runner.orEmpty()}",
                        Notification.Type.Info
                    )
                )
            }
        )
    )
}

@Composable
internal actual fun BoxScope.ScrollBar(state: LazyListState) {
    VerticalScrollbar(
        modifier = Modifier
            .align(Alignment.CenterEnd)
            .fillMaxHeight(),
        adapter = rememberScrollbarAdapter(scrollState = state)
    )
}