package com.programmersbox.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

@Composable
internal fun App(
    appActions: AppActions = AppActions(),
    driverFactory: DriverFactory
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        CompositionLocalProvider(LocalAppActions provides appActions) {
            Surface {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    val scope = rememberCoroutineScope()
                    val vm = remember { GameViewModel(driverFactory, scope) }
                    GDQSchedule(
                        viewModel = vm
                    )
                }
            }
        }
    }
}

@Immutable
internal data class AppActions(
    val onSaveToNotify: (FullGameInfo) -> Unit = {},
    val onSaveReminder: (FullGameInfo) -> Unit = {},
    val onDeleteReminder: (FullGameInfo) -> Unit = {},
    val setupReminderTimer: (CoroutineScope, List<FullGameInfo>) -> Unit = { _, _ -> }
)

internal val LocalAppActions = staticCompositionLocalOf<AppActions> { error("No Actions") }
