package com.programmersbox.common

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable

public expect fun getPlatformName(): String

@Composable
internal expect fun BoxScope.ScrollBar(state: LazyListState)