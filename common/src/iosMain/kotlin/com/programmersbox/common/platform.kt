package com.programmersbox.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import platform.UIKit.UIViewController
import kotlin.native.concurrent.ThreadLocal

public actual fun getPlatformName(): String {
    return "iOS"
}

@Composable
private fun UIShow() {
    App(
        driverFactory = remember { DriverFactory() },
    )
}

public fun MainViewController(
    setup: (String) -> List<GameInfo?>
): UIViewController {
    Napier.base(DebugAntilog())
    InfoStuff.setup = setup
    return Application("GDQ Schedule") {
        MaterialTheme(
            colorScheme = darkColorScheme()
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Spacer(Modifier.height(30.dp))
                    UIShow()
                }
            }
        }
    }
}

public fun toJson(item: GameInfo): String = Json.encodeToString(item)

@ThreadLocal
internal object InfoStuff {

    var setup: (String) -> List<GameInfo?> = { emptyList() }

}

@Composable
internal actual fun BoxScope.ScrollBar(state: LazyListState) {
}