package com.programmersbox.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun App() {
    MaterialTheme(
        colorScheme = if (true) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val vm = remember { GameViewModel() }
                LaunchedEffect(Unit) { vm.init() }
                GDQSchedule(
                    viewModel = vm,
                    onSaveToNotify = {}
                )
            }
        }
    }
}