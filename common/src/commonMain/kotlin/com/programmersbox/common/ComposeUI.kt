package com.programmersbox.common

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import kotlinx.coroutines.delay
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalPagerApi::class,
)
@Composable
internal fun GDQSchedule(
    viewModel: GameViewModel,
    onSaveToNotify: (GameInfo) -> Unit
) {

    val currentTime by currentTime()
    val scope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    //val topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarScrollState())
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

            }
        },
        gesturesEnabled = drawerState.isOpen
    ) {
        Scaffold(
            //modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = { Text("GDQ Schedule") },
                    //scrollBehavior = topBarBehavior,
                    actions = {
                        val uriHandler = LocalUriHandler.current
                        IconButton(
                            onClick = { uriHandler.openUri("https://gamesdonequick.com/donate") }
                        ) { Icon(Icons.Default.AttachMoney, null) }
                        IconButton(
                            onClick = { uriHandler.openUri("https://www.twitch.tv/gamesdonequick") }
                        ) {
                            //Icon(painterResource(id = R.drawable.twitchtv), null)
                            Icon(Icons.Default.Tv, null)
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    actions = {
                        val time = currentTime.toLocalDateTime(TimeZone.currentSystemDefault())
                        val hour = time.hour
                        val minute = time.minute
                        Text("${time.month} ${time.dayOfMonth}, $hour:$minute")
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.MenuOpen, contentDescription = null)
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                val pagerState = rememberPagerState()
                val days = viewModel.gameInfoGrouped
                if (days.isNotEmpty()) {

                    LaunchedEffect(Unit) {
                        val c = days.keys.indexOf(viewModel.dateFormat(currentTime))
                        if (c != -1) pagerState.animateScrollToPage(c)
                    }

                    ScrollableTabRow(
                        //containerColor = TopAppBarDefaults.smallTopAppBarColors()
                            //.containerColor(scrollFraction = topBarBehavior.scrollFraction).value,
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                            )
                        }
                    ) {
                        days.keys.forEachIndexed { index, title ->
                            Tab(
                                text = { Text(title) },
                                selected = pagerState.currentPage == index,
                                onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
                            )
                        }
                    }

                    HorizontalPager(
                        count = days.keys.size,
                        state = pagerState,
                        modifier = Modifier.fillMaxSize()
                    ) { page ->
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val state = rememberLazyListState()

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(2.dp),
                                contentPadding = PaddingValues(top = 2.dp, bottom = 2.dp),
                                state = state
                            ) {
                                val list = days.values.toList()[page]
                                itemsIndexed(list) { i, it ->
                                    val d = currentTime
                                    val isCurrentGame =
                                        if (it.startTimeAsDate != null && list.getOrNull(i + 1)?.startTimeAsDate != null) {
                                            d > it.startTimeAsDate!! && d < list.getOrNull(i + 1)?.startTimeAsDate!!
                                        } else false

                                    val cardColor =
                                        if (isCurrentGame) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface

                                    ListItem(
                                        modifier = Modifier
                                            .border(
                                                4.dp,
                                                animateColorAsState(cardColor).value,
                                                MaterialTheme.shapes.small
                                            )
                                            .fillMaxWidth(),
                                        headlineText = { Text(it.game!!) },
                                        supportingText = {
                                            Column {
                                                Text(it.info!!)
                                                Text(it.runner!!)
                                            }
                                        },
                                        overlineText = { Text(it.time!!) },
                                        leadingContent = { it.startTimeReadable?.let { it1 -> Text(it1) } },
                                        trailingContent = if (it.startTimeAsDate?.let { d < it } == true) {
                                            {
                                                var toggle by remember { mutableStateOf(false) }

                                                IconToggleButton(
                                                    checked = toggle,
                                                    onCheckedChange = { b ->
                                                        if (b) {

                                                        } else {

                                                        }
                                                        toggle = b
                                                    }
                                                ) {
                                                    Icon(
                                                        Icons.Default.NotificationsActive,
                                                        contentDescription = null,
                                                        tint = animateColorAsState(
                                                            if (toggle && isCurrentGame) Color(0xFFe74c3c)
                                                            else LocalContentColor.current
                                                        ).value
                                                    )
                                                }
                                            }
                                        } else null
                                    )
                                    Divider(modifier = Modifier.padding(top = 2.dp))
                                }
                            }

                            ScrollBar(state)
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
internal fun Modifier.pagerTabIndicatorOffset(
    pagerState: PagerState,
    tabPositions: List<TabPosition>,
    pageIndexMapping: (Int) -> Int = { it },
): Modifier = layout { measurable, constraints ->
    if (tabPositions.isEmpty()) {
        // If there are no pages, nothing to show
        layout(constraints.maxWidth, 0) {}
    } else {
        val currentPage = minOf(tabPositions.lastIndex, pageIndexMapping(pagerState.currentPage))
        val currentTab = tabPositions[currentPage]
        val previousTab = tabPositions.getOrNull(currentPage - 1)
        val nextTab = tabPositions.getOrNull(currentPage + 1)
        val fraction = pagerState.currentPageOffset
        val indicatorWidth = if (fraction > 0 && nextTab != null) {
            lerp(currentTab.width, nextTab.width, fraction).roundToPx()
        } else if (fraction < 0 && previousTab != null) {
            lerp(currentTab.width, previousTab.width, -fraction).roundToPx()
        } else {
            currentTab.width.roundToPx()
        }
        val indicatorOffset = if (fraction > 0 && nextTab != null) {
            lerp(currentTab.left, nextTab.left, fraction).roundToPx()
        } else if (fraction < 0 && previousTab != null) {
            lerp(currentTab.left, previousTab.left, -fraction).roundToPx()
        } else {
            currentTab.left.roundToPx()
        }
        val placeable = measurable.measure(
            Constraints(
                minWidth = indicatorWidth,
                maxWidth = indicatorWidth,
                minHeight = 0,
                maxHeight = constraints.maxHeight
            )
        )
        layout(constraints.maxWidth, maxOf(placeable.height, constraints.minHeight)) {
            placeable.place(
                indicatorOffset,
                maxOf(constraints.minHeight - placeable.height, 0)
            )
        }
    }
}

/**
 * Creates a broadcast receiver that gets the time every tick that Android takes and
 * unregisters the receiver when the view is at the end of its lifecycle
 */
@Composable
internal fun currentTime(): State<Instant> = produceState(Clock.System.now()) {
    while (true) {
        value = Clock.System.now()
        delay(1)
    }
}