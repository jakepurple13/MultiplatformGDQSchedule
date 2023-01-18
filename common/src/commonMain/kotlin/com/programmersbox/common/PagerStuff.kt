package com.programmersbox.common

import androidx.compose.animation.core.*
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlin.math.*


/**
 * Library-wide switch to turn on debug logging.
 */
internal const val DebugLog = false

@RequiresOptIn(message = "Accompanist Pager is experimental. The API may be changed in the future.")
@Retention(AnnotationRetention.BINARY)
internal annotation class ExperimentalPagerApi

/**
 * Contains the default values used by [HorizontalPager] and [VerticalPager].
 */
@ExperimentalPagerApi
internal object PagerDefaults {
    /**
     * The default implementation for the `maximumFlingDistance` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @ExperimentalSnapperApi
    @Suppress("MemberVisibilityCanBePrivate")
    @Deprecated("MaximumFlingDistance has been deprecated in Snapper")
    internal val singlePageFlingDistance: (SnapperLayoutInfo) -> Float = { layoutInfo ->
        // We can scroll up to the scrollable size of the lazy layout
        layoutInfo.endScrollOffset - layoutInfo.startScrollOffset.toFloat()
    }

    /**
     * The default implementation for the `snapIndex` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @ExperimentalSnapperApi
    internal val singlePageSnapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int =
        { layoutInfo, startIndex, targetIndex ->
            targetIndex
                .coerceIn(startIndex - 1, startIndex + 1)
                .coerceIn(0, layoutInfo.totalItemsCount - 1)
        }

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param maximumFlingDistance Block which returns the maximum fling distance in pixels.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     */
    @Composable
    @ExperimentalSnapperApi
    @Deprecated("MaximumFlingDistance has been deprecated in Snapper, replaced with snapIndex")
    @Suppress("DEPRECATION")
    internal fun flingBehavior(
        state: PagerState,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        maximumFlingDistance: (SnapperLayoutInfo) -> Float = singlePageFlingDistance,
        endContentPadding: Dp = 0.dp,
    ): FlingBehavior = rememberSnapperFlingBehavior(
        lazyListState = state.lazyListState,
        snapOffsetForItem = SnapOffsets.Start, // pages are full width, so we use the simplest
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = snapAnimationSpec,
        maximumFlingDistance = maximumFlingDistance,
        endContentPadding = endContentPadding,
    )

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     * @param snapIndex Block which returns the index to snap to. The block is provided with the
     * [SnapperLayoutInfo], the index where the fling started, and the index which Snapper has
     * determined is the correct target index. Callers can override this value to any valid index
     * for the layout. Some common use cases include limiting the fling distance, and rounding up/down
     * to achieve snapping to groups of items.
     */
    @Composable
    @ExperimentalSnapperApi
    internal fun flingBehavior(
        state: PagerState,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        endContentPadding: Dp = 0.dp,
        snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int,
    ): FlingBehavior = rememberSnapperFlingBehavior(
        lazyListState = state.lazyListState,
        snapOffsetForItem = SnapOffsets.Start, // pages are full width, so we use the simplest
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = snapAnimationSpec,
        endContentPadding = endContentPadding,
        snapIndex = snapIndex,
    )

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     */
    @Composable
    @ExperimentalSnapperApi
    internal fun flingBehavior(
        state: PagerState,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        endContentPadding: Dp = 0.dp,
    ): FlingBehavior {
        // You might be wondering this is function exists rather than a default value for snapIndex
        // above. It was done to remove overload ambiguity with the maximumFlingDistance overload
        // below. When that function is removed, we also remove this function and move to a default
        // param value.
        return flingBehavior(
            state = state,
            decayAnimationSpec = decayAnimationSpec,
            snapAnimationSpec = snapAnimationSpec,
            endContentPadding = endContentPadding,
            snapIndex = singlePageSnapIndex,
        )
    }
}

/**
 * A horizontally scrolling layout that allows users to flip between items to the left and right.
 *
 * @sample com.google.accompanist.sample.pager.HorizontalPagerSample
 *
 * @param count the number of pages.
 * @param modifier the modifier to apply to this layout.
 * @param state the state object to be used to control or observe the pager's state.
 * @param reverseLayout reverse the direction of scrolling and layout, when `true` items will be
 * composed from the end to the start and [PagerState.currentPage] == 0 will mean
 * the first item is located at the end.
 * @param itemSpacing horizontal spacing to add between items.
 * @param flingBehavior logic describing fling behavior.
 * @param key the scroll position will be maintained based on the key, which means if you
 * add/remove items before the current visible item the item with the given key will be kept as the
 * first visible one.
 * @param userScrollEnabled whether the scrolling via the user gestures or accessibility actions
 * is allowed. You can still scroll programmatically using the state even when it is disabled.
 * @param content a block which describes the content. Inside this block you can reference
 * [PagerScope.currentPage] and other properties in [PagerScope].
 */
@OptIn(ExperimentalSnapperApi::class)
@ExperimentalPagerApi
@Composable
internal fun HorizontalPager(
    count: Int,
    modifier: Modifier = Modifier,
    state: PagerState = rememberPagerState(),
    reverseLayout: Boolean = false,
    itemSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    flingBehavior: FlingBehavior = PagerDefaults.flingBehavior(
        state = state,
        endContentPadding = contentPadding.calculateEndPadding(LayoutDirection.Ltr),
    ),
    key: ((page: Int) -> Any)? = null,
    userScrollEnabled: Boolean = true,
    content: @Composable PagerScope.(page: Int) -> Unit,
) {
    Pager(
        count = count,
        state = state,
        modifier = modifier,
        isVertical = false,
        reverseLayout = reverseLayout,
        itemSpacing = itemSpacing,
        verticalAlignment = verticalAlignment,
        flingBehavior = flingBehavior,
        key = key,
        contentPadding = contentPadding,
        userScrollEnabled = userScrollEnabled,
        content = content
    )
}

/**
 * A vertically scrolling layout that allows users to flip between items to the top and bottom.
 *
 * @sample com.google.accompanist.sample.pager.VerticalPagerSample
 *
 * @param count the number of pages.
 * @param modifier the modifier to apply to this layout.
 * @param state the state object to be used to control or observe the pager's state.
 * @param reverseLayout reverse the direction of scrolling and layout, when `true` items will be
 * composed from the bottom to the top and [PagerState.currentPage] == 0 will mean
 * the first item is located at the bottom.
 * @param itemSpacing vertical spacing to add between items.
 * @param flingBehavior logic describing fling behavior.
 * @param key the scroll position will be maintained based on the key, which means if you
 * add/remove items before the current visible item the item with the given key will be kept as the
 * first visible one.
 * @param userScrollEnabled whether the scrolling via the user gestures or accessibility actions
 * is allowed. You can still scroll programmatically using the state even when it is disabled.
 * @param content a block which describes the content. Inside this block you can reference
 * [PagerScope.currentPage] and other properties in [PagerScope].
 */
@OptIn(ExperimentalSnapperApi::class)
@ExperimentalPagerApi
@Composable
internal fun VerticalPager(
    count: Int,
    modifier: Modifier = Modifier,
    state: PagerState = rememberPagerState(),
    reverseLayout: Boolean = false,
    itemSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    flingBehavior: FlingBehavior = PagerDefaults.flingBehavior(
        state = state,
        endContentPadding = contentPadding.calculateBottomPadding(),
    ),
    key: ((page: Int) -> Any)? = null,
    userScrollEnabled: Boolean = true,
    content: @Composable PagerScope.(page: Int) -> Unit,
) {
    Pager(
        count = count,
        state = state,
        modifier = modifier,
        isVertical = true,
        reverseLayout = reverseLayout,
        itemSpacing = itemSpacing,
        horizontalAlignment = horizontalAlignment,
        flingBehavior = flingBehavior,
        key = key,
        contentPadding = contentPadding,
        userScrollEnabled = userScrollEnabled,
        content = content
    )
}

@ExperimentalPagerApi
@Composable
internal fun Pager(
    count: Int,
    modifier: Modifier,
    state: PagerState,
    reverseLayout: Boolean,
    itemSpacing: Dp,
    isVertical: Boolean,
    flingBehavior: FlingBehavior,
    key: ((page: Int) -> Any)?,
    contentPadding: PaddingValues,
    userScrollEnabled: Boolean,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable PagerScope.(page: Int) -> Unit,
) {
    require(count >= 0) { "pageCount must be >= 0" }

    // Provide our PagerState with access to the SnappingFlingBehavior animation target
    // TODO: can this be done in a better way?
    state.flingAnimationTarget = {
        @OptIn(ExperimentalSnapperApi::class)
        (flingBehavior as? SnapperFlingBehavior)?.animationTarget
    }

    LaunchedEffect(count) {
        state.currentPage = minOf(count - 1, state.currentPage).coerceAtLeast(0)
    }

    // Once a fling (scroll) has finished, notify the state
    LaunchedEffect(state) {
        // When a 'scroll' has finished, notify the state
        snapshotFlow { state.isScrollInProgress }
            .filter { !it }
            // initially isScrollInProgress is false as well and we want to start receiving
            // the events only after the real scroll happens.
            .drop(1)
            .collect { state.onScrollFinished() }
    }
    LaunchedEffect(state) {
        snapshotFlow { state.mostVisiblePageLayoutInfo?.index }
            .distinctUntilChanged()
            .collect { state.updateCurrentPageBasedOnLazyListState() }
    }
    val density = LocalDensity.current
    LaunchedEffect(density, state, itemSpacing) {
        with(density) { state.itemSpacing = itemSpacing.roundToPx() }
    }

    val pagerScope = remember(state) { PagerScopeImpl(state) }

    // We only consume nested flings in the main-axis, allowing cross-axis flings to propagate
    // as normal
    val consumeFlingNestedScrollConnection = remember(isVertical) {
        ConsumeFlingNestedScrollConnection(
            consumeHorizontal = !isVertical,
            consumeVertical = isVertical,
            pagerState = state,
        )
    }

    if (isVertical) {
        LazyColumn(
            state = state.lazyListState,
            verticalArrangement = Arrangement.spacedBy(itemSpacing, verticalAlignment),
            horizontalAlignment = horizontalAlignment,
            flingBehavior = flingBehavior,
            reverseLayout = reverseLayout,
            contentPadding = contentPadding,
            userScrollEnabled = userScrollEnabled,
            modifier = modifier,
        ) {
            items(
                count = count,
                key = key,
            ) { page ->
                Box(
                    Modifier
                        // We don't any nested flings to continue in the pager, so we add a
                        // connection which consumes them.
                        // See: https://github.com/google/accompanist/issues/347
                        .nestedScroll(connection = consumeFlingNestedScrollConnection)
                        // Constraint the content height to be <= than the height of the pager.
                        .fillParentMaxHeight()
                        .wrapContentSize()
                ) {
                    pagerScope.content(page)
                }
            }
        }
    } else {
        LazyRow(
            state = state.lazyListState,
            verticalAlignment = verticalAlignment,
            horizontalArrangement = Arrangement.spacedBy(itemSpacing, horizontalAlignment),
            flingBehavior = flingBehavior,
            reverseLayout = reverseLayout,
            contentPadding = contentPadding,
            userScrollEnabled = userScrollEnabled,
            modifier = modifier,
        ) {
            items(
                count = count,
                key = key,
            ) { page ->
                Box(
                    Modifier
                        // We don't any nested flings to continue in the pager, so we add a
                        // connection which consumes them.
                        // See: https://github.com/google/accompanist/issues/347
                        .nestedScroll(connection = consumeFlingNestedScrollConnection)
                        // Constraint the content width to be <= than the width of the pager.
                        .fillParentMaxWidth()
                        .wrapContentSize()
                ) {
                    pagerScope.content(page)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
private class ConsumeFlingNestedScrollConnection(
    private val consumeHorizontal: Boolean,
    private val consumeVertical: Boolean,
    private val pagerState: PagerState,
) : NestedScrollConnection {
    override fun onPostScroll(
        consumed: Offset,
        available: Offset,
        source: NestedScrollSource
    ): Offset = when (source) {
        // We can consume all resting fling scrolls so that they don't propagate up to the
        // Pager
        NestedScrollSource.Fling -> available.consume(consumeHorizontal, consumeVertical)
        else -> Offset.Zero
    }

    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        return if (pagerState.currentPageOffset != 0f) {
            // The Pager is already scrolling. This means that a nested scroll child was
            // scrolled to end, and the Pager can use this fling
            Velocity.Zero
        } else {
            // A nested scroll child is still scrolling. We can consume all post fling
            // velocity on the main-axis so that it doesn't propagate up to the Pager
            available.consume(consumeHorizontal, consumeVertical)
        }
    }
}

private fun Offset.consume(
    consumeHorizontal: Boolean,
    consumeVertical: Boolean,
): Offset = Offset(
    x = if (consumeHorizontal) this.x else 0f,
    y = if (consumeVertical) this.y else 0f,
)

private fun Velocity.consume(
    consumeHorizontal: Boolean,
    consumeVertical: Boolean,
): Velocity = Velocity(
    x = if (consumeHorizontal) this.x else 0f,
    y = if (consumeVertical) this.y else 0f,
)

/**
 * Scope for [HorizontalPager] content.
 */
@ExperimentalPagerApi
@Stable
internal interface PagerScope {
    /**
     * Returns the current selected page
     */
    val currentPage: Int

    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     */
    val currentPageOffset: Float
}

@ExperimentalPagerApi
private class PagerScopeImpl(
    private val state: PagerState,
) : PagerScope {
    override val currentPage: Int get() = state.currentPage
    override val currentPageOffset: Float get() = state.currentPageOffset
}

/**
 * Calculate the offset for the given [page] from the current scroll position. This is useful
 * when using the scroll position to apply effects or animations to items.
 *
 * The returned offset can positive or negative, depending on whether which direction the [page] is
 * compared to the current scroll position.
 *
 * @sample com.google.accompanist.sample.pager.HorizontalPagerWithOffsetTransition
 */
@ExperimentalPagerApi
internal fun PagerScope.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffset
}

/**
 * Creates a [PagerState] that is remembered across compositions.
 *
 * Changes to the provided values for [initialPage] will **not** result in the state being
 * recreated or changed in any way if it has already
 * been created.
 *
 * @param initialPage the initial value for [PagerState.currentPage]
 */
@ExperimentalPagerApi
@Composable
internal fun rememberPagerState(
    initialPage: Int = 0,
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        currentPage = initialPage,
    )
}

/**
 * A state object that can be hoisted to control and observe scrolling for [HorizontalPager].
 *
 * In most cases, this will be created via [rememberPagerState].
 *
 * @param currentPage the initial value for [PagerState.currentPage]
 */
@ExperimentalPagerApi
@Stable
internal class PagerState(
    currentPage: Int = 0,
) : ScrollableState {
    // Should this be internal?
    internal val lazyListState = LazyListState(firstVisibleItemIndex = currentPage)

    private var _currentPage by mutableStateOf(currentPage)

    // finds the page which has larger visible area within the viewport not including paddings
    internal val mostVisiblePageLayoutInfo: LazyListItemInfo?
        get() {
            val layoutInfo = lazyListState.layoutInfo
            return layoutInfo.visibleItemsInfo.maxByOrNull {
                val start = maxOf(it.offset, 0)
                val end = minOf(
                    it.offset + it.size,
                    layoutInfo.viewportEndOffset - layoutInfo.afterContentPadding
                )
                end - start
            }
        }

    internal var itemSpacing by mutableStateOf(0)

    private val currentPageLayoutInfo: LazyListItemInfo?
        get() = lazyListState.layoutInfo.visibleItemsInfo.lastOrNull {
            it.index == currentPage
        }

    /**
     * [InteractionSource] that will be used to dispatch drag events when this
     * list is being dragged. If you want to know whether the fling (or animated scroll) is in
     * progress, use [isScrollInProgress].
     */
    val interactionSource: InteractionSource
        get() = lazyListState.interactionSource

    /**
     * The number of pages to display.
     */
    val pageCount: Int by derivedStateOf {
        lazyListState.layoutInfo.totalItemsCount
    }

    /**
     * The index of the currently selected page. This may not be the page which is
     * currently displayed on screen.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    var currentPage: Int
        get() = _currentPage
        internal set(value) {
            if (value != _currentPage) {
                _currentPage = value
            }
        }

    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    val currentPageOffset: Float by derivedStateOf {
        currentPageLayoutInfo?.let {
            (-it.offset / (it.size + itemSpacing).toFloat()).coerceIn(-0.5f, 0.5f)
        } ?: 0f
    }

    /**
     * The target page for any on-going animations.
     */
    private var animationTargetPage: Int? by mutableStateOf(null)

    internal var flingAnimationTarget: (() -> Int?)? by mutableStateOf(null)

    /**
     * The target page for any on-going animations or scrolls by the user.
     * Returns the current page if a scroll or animation is not currently in progress.
     */
    @Deprecated(
        "targetPage is deprecated in favor of currentPage as currentPage property is" +
                "now being updated right after we over scrolled the half of the previous current page." +
                "If you still think that you need targetPage, not currentPage please file a bug as " +
                "we are planning to remove this property in future.",
        ReplaceWith("currentPage")
    )
    val targetPage: Int
        get() = animationTargetPage
            ?: flingAnimationTarget?.invoke()
            ?: when {
                // If a scroll isn't in progress, return the current page
                !isScrollInProgress -> currentPage
                // If the offset is 0f (or very close), return the current page
                currentPageOffset.absoluteValue < 0.001f -> currentPage
                // If we're offset towards the start, guess the previous page
                currentPageOffset < 0f -> (currentPage - 1).coerceAtLeast(0)
                // If we're offset towards the end, guess the next page
                else -> (currentPage + 1).coerceAtMost(pageCount - 1)
            }

    @Deprecated(
        "Replaced with animateScrollToPage(page, pageOffset)",
        ReplaceWith("animateScrollToPage(page = page, pageOffset = pageOffset)")
    )
    @Suppress("UNUSED_PARAMETER")
    suspend fun animateScrollToPage(
        page: Int,
        pageOffset: Float = 0f,
        animationSpec: AnimationSpec<Float> = spring(),
        initialVelocity: Float = 0f,
        skipPages: Boolean = true,
    ) {
        animateScrollToPage(page = page, pageOffset = pageOffset)
    }

    /**
     * Animate (smooth scroll) to the given page to the middle of the viewport.
     *
     * Cancels the currently running scroll, if any, and suspends until the cancellation is
     * complete.
     *
     * @param page the page to animate to. Must be >= 0.
     * @param pageOffset the percentage of the page size to offset, from the start of [page].
     * Must be in the range -1f..1f.
     */
    suspend fun animateScrollToPage(
        page: Int,
        pageOffset: Float = 0f,
    ) {
        requireCurrentPage(page, "page")
        requireCurrentPageOffset(pageOffset, "pageOffset")
        try {
            animationTargetPage = page

            // pre-jump to nearby item for long jumps as an optimization
            // the same trick is done in ViewPager2
            val oldPage = lazyListState.firstVisibleItemIndex
            if (abs(page - oldPage) > 3) {
                lazyListState.scrollToItem(if (page > oldPage) page - 3 else page + 3)
            }

            if (pageOffset.absoluteValue <= 0.005f) {
                // If the offset is (close to) zero, just call animateScrollToItem and we're done
                lazyListState.animateScrollToItem(index = page)
            } else {
                // Else we need to figure out what the offset is in pixels...
                lazyListState.scroll { } // this will await for the first layout.
                val layoutInfo = lazyListState.layoutInfo
                var target = layoutInfo.visibleItemsInfo
                    .firstOrNull { it.index == page }

                if (target != null) {
                    // If we have access to the target page layout, we can calculate the pixel
                    // offset from the size
                    lazyListState.animateScrollToItem(
                        index = page,
                        scrollOffset = ((target.size + itemSpacing) * pageOffset).roundToInt()
                    )
                } else if (layoutInfo.visibleItemsInfo.isNotEmpty()) {
                    // If we don't, we use the current page size as a guide
                    val currentSize = layoutInfo.visibleItemsInfo.first().size + itemSpacing
                    lazyListState.animateScrollToItem(
                        index = page,
                        scrollOffset = (currentSize * pageOffset).roundToInt()
                    )

                    // The target should be visible now
                    target = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull { it.index == page }

                    if (target != null && target.size + itemSpacing != currentSize) {
                        // If the size we used for calculating the offset differs from the actual
                        // target page size, we need to scroll again. This doesn't look great,
                        // but there's not much else we can do.
                        lazyListState.animateScrollToItem(
                            index = page,
                            scrollOffset = ((target.size + itemSpacing) * pageOffset).roundToInt()
                        )
                    }
                }
            }
        } finally {
            // We need to manually call this, as the `animateScrollToItem` call above will happen
            // in 1 frame, which is usually too fast for the LaunchedEffect in Pager to detect
            // the change. This is especially true when running unit tests.
            onScrollFinished()
        }
    }

    /**
     * Instantly brings the item at [page] to the middle of the viewport.
     *
     * Cancels the currently running scroll, if any, and suspends until the cancellation is
     * complete.
     *
     * @param page the page to snap to. Must be >= 0.
     * @param pageOffset the percentage of the page size to offset, from the start of [page].
     * Must be in the range -1f..1f.
     */
    suspend fun scrollToPage(
        page: Int,
        pageOffset: Float = 0f,
    ) {
        requireCurrentPage(page, "page")
        requireCurrentPageOffset(pageOffset, "pageOffset")
        try {
            animationTargetPage = page

            // First scroll to the given page. It will now be laid out at offset 0
            lazyListState.scrollToItem(index = page)
            updateCurrentPageBasedOnLazyListState()

            // If we have a start spacing, we need to offset (scroll) by that too
            if (pageOffset.absoluteValue > 0.0001f) {
                currentPageLayoutInfo?.let {
                    scroll {
                        scrollBy((it.size + itemSpacing) * pageOffset)
                    }
                }
            }
        } finally {
            // We need to manually call this, as the `scroll` call above will happen in 1 frame,
            // which is usually too fast for the LaunchedEffect in Pager to detect the change.
            // This is especially true when running unit tests.
            onScrollFinished()
        }
    }

    internal fun updateCurrentPageBasedOnLazyListState() {
        // Then update the current page to our layout page
        mostVisiblePageLayoutInfo?.let {
            currentPage = it.index
        }
    }

    internal fun onScrollFinished() {
        // Clear the animation target page
        animationTargetPage = null
    }

    override suspend fun scroll(
        scrollPriority: MutatePriority,
        block: suspend ScrollScope.() -> Unit
    ) = lazyListState.scroll(scrollPriority, block)

    override fun dispatchRawDelta(delta: Float): Float {
        return lazyListState.dispatchRawDelta(delta)
    }

    override val isScrollInProgress: Boolean
        get() = lazyListState.isScrollInProgress

    override fun toString(): String = "PagerState(" +
            "pageCount=$pageCount, " +
            "currentPage=$currentPage, " +
            "currentPageOffset=$currentPageOffset" +
            ")"

    private fun requireCurrentPage(value: Int, name: String) {
        require(value >= 0) { "$name[$value] must be >= 0" }
    }

    private fun requireCurrentPageOffset(value: Float, name: String) {
        require(value in -1f..1f) { "$name must be >= -1 and <= 1" }
    }

    companion object {
        /**
         * The default [Saver] implementation for [PagerState].
         */
        val Saver: Saver<PagerState, *> = listSaver(
            save = {
                listOf<Any>(
                    it.currentPage,
                )
            },
            restore = {
                PagerState(
                    currentPage = it[0] as Int,
                )
            }
        )
    }
}

@RequiresOptIn(message = "Snapper is experimental. The API may be changed in the future.")
@Retention(AnnotationRetention.BINARY)
internal annotation class ExperimentalSnapperApi

/**
 * Default values used for [SnapperFlingBehavior] & [rememberSnapperFlingBehavior].
 */
@ExperimentalSnapperApi
internal object SnapperFlingBehaviorDefaults {
    /**
     * [AnimationSpec] used as the default value for the `snapAnimationSpec` parameter on
     * [rememberSnapperFlingBehavior] and [SnapperFlingBehavior].
     */
    internal val SpringAnimationSpec: AnimationSpec<Float> = spring(stiffness = 400f)

    /**
     * The default implementation for the `maximumFlingDistance` parameter of
     * [rememberSnapperFlingBehavior] and [SnapperFlingBehavior], which does not limit
     * the fling distance.
     */
    @Deprecated("The maximumFlingDistance parameter has been deprecated.")
    internal val MaximumFlingDistance: (SnapperLayoutInfo) -> Float = { Float.MAX_VALUE }

    /**
     * The default implementation for the `snapIndex` parameter of
     * [rememberSnapperFlingBehavior] and [SnapperFlingBehavior].
     */
    internal val SnapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int = { _, _, targetIndex -> targetIndex }
}

/**
 * Create and remember a snapping [FlingBehavior] to be used with the given [layoutInfo].
 *
 * @param layoutInfo The [SnapperLayoutInfo] to use. For lazy layouts,
 * you can use [rememberLazyListSnapperLayoutInfo].
 * @param decayAnimationSpec The decay animation spec to use for decayed flings.
 * @param springAnimationSpec The animation spec to use when snapping.
 * @param snapIndex Block which returns the index to snap to. The block is provided with the
 * [SnapperLayoutInfo], the index where the fling started, and the index which Snapper has
 * determined is the correct target index. Callers can override this value to any valid index
 * for the layout. Some common use cases include limiting the fling distance, and rounding up/down
 * to achieve snapping to groups of items.
 */
@ExperimentalSnapperApi
@Composable
internal fun rememberSnapperFlingBehavior(
    layoutInfo: SnapperLayoutInfo,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
    snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int,
): SnapperFlingBehavior = remember(
    layoutInfo,
    decayAnimationSpec,
    springAnimationSpec,
    snapIndex,
) {
    SnapperFlingBehavior(
        layoutInfo = layoutInfo,
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = springAnimationSpec,
        snapIndex = snapIndex,
    )
}

/**
 * Create and remember a snapping [FlingBehavior] to be used with the given [layoutInfo].
 *
 * @param layoutInfo The [SnapperLayoutInfo] to use. For lazy layouts,
 * you can use [rememberLazyListSnapperLayoutInfo].
 * @param decayAnimationSpec The decay animation spec to use for decayed flings.
 * @param springAnimationSpec The animation spec to use when snapping.
 */
@ExperimentalSnapperApi
@Composable
internal inline fun rememberSnapperFlingBehavior(
    layoutInfo: SnapperLayoutInfo,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
): SnapperFlingBehavior {
    // You might be wondering this is function exists rather than a default value for snapIndex
    // above. It was done to remove overload ambiguity with the maximumFlingDistance overload
    // below. When that function is removed, we also remove this function and move to a default
    // param value.
    return rememberSnapperFlingBehavior(
        layoutInfo = layoutInfo,
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = springAnimationSpec,
        snapIndex = SnapperFlingBehaviorDefaults.SnapIndex
    )
}

/**
 * Create and remember a snapping [FlingBehavior] to be used with the given [layoutInfo].
 *
 * @param layoutInfo The [SnapperLayoutInfo] to use. For lazy layouts,
 * you can use [rememberLazyListSnapperLayoutInfo].
 * @param decayAnimationSpec The decay animation spec to use for decayed flings.
 * @param springAnimationSpec The animation spec to use when snapping.
 * @param maximumFlingDistance Block which returns the maximum fling distance in pixels.
 * The returned value should be > 0.
 */
@Suppress("DEPRECATION")
@ExperimentalSnapperApi
@Deprecated("The maximumFlingDistance parameter has been replaced with snapIndex")
@Composable
internal fun rememberSnapperFlingBehavior(
    layoutInfo: SnapperLayoutInfo,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
    maximumFlingDistance: (SnapperLayoutInfo) -> Float = SnapperFlingBehaviorDefaults.MaximumFlingDistance,
): SnapperFlingBehavior = remember(
    layoutInfo,
    decayAnimationSpec,
    springAnimationSpec,
    maximumFlingDistance,
) {
    SnapperFlingBehavior(
        layoutInfo = layoutInfo,
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = springAnimationSpec,
        maximumFlingDistance = maximumFlingDistance,
    )
}

/**
 * Contains the necessary information about the scrolling layout for [SnapperFlingBehavior]
 * to determine how to fling.
 */
@ExperimentalSnapperApi
internal abstract class SnapperLayoutInfo {
    /**
     * The start offset of where items can be scrolled to. This value should only include
     * scrollable regions. For example this should not include fixed content padding.
     * For most layouts, this will be 0.
     */
    internal abstract val startScrollOffset: Int

    /**
     * The end offset of where items can be scrolled to. This value should only include
     * scrollable regions. For example this should not include fixed content padding.
     * For most layouts, this will the width of the container, minus content padding.
     */
    internal abstract val endScrollOffset: Int

    /**
     * A sequence containing the currently visible items in the layout.
     */
    internal abstract val visibleItems: Sequence<SnapperLayoutItemInfo>

    /**
     * The current item which covers the desired snap point, or null if there is no item.
     * The item returned may not yet currently be snapped into the final position.
     */
    internal abstract val currentItem: SnapperLayoutItemInfo?

    /**
     * The total count of items attached to the layout.
     */
    internal abstract val totalItemsCount: Int

    /**
     * Calculate the desired target which should be scrolled to for the given [velocity].
     *
     * @param velocity Velocity of the fling. This can be 0.
     * @param decayAnimationSpec The decay fling animation spec.
     * @param maximumFlingDistance The maximum distance in pixels which should be scrolled.
     */
    internal abstract fun determineTargetIndex(
        velocity: Float,
        decayAnimationSpec: DecayAnimationSpec<Float>,
        maximumFlingDistance: Float,
    ): Int

    /**
     * Calculate the distance in pixels needed to scroll to the given [index]. The value returned
     * signifies which direction to scroll in:
     *
     * - Positive values indicate to scroll towards the end.
     * - Negative values indicate to scroll towards the start.
     *
     * If a precise calculation can not be found, a realistic estimate is acceptable.
     */
    internal abstract fun distanceToIndexSnap(index: Int): Int

    /**
     * Returns true if the layout has some scroll range remaining to scroll towards the start.
     */
    internal abstract fun canScrollTowardsStart(): Boolean

    /**
     * Returns true if the layout has some scroll range remaining to scroll towards the end.
     */
    internal abstract fun canScrollTowardsEnd(): Boolean
}

/**
 * Contains information about a single item in a scrolling layout.
 */
internal abstract class SnapperLayoutItemInfo {
    internal abstract val index: Int
    internal abstract val offset: Int
    internal abstract val size: Int

    override fun toString(): String {
        return "SnapperLayoutItemInfo(index=$index, offset=$offset, size=$size)"
    }
}

/**
 * Contains a number of values which can be used for the `snapOffsetForItem` parameter on
 * [rememberLazyListSnapperLayoutInfo] and [LazyListSnapperLayoutInfo].
 */
@ExperimentalSnapperApi
@Suppress("unused") // internal vals which aren't used in the project
internal object SnapOffsets {
    /**
     * Snap offset which results in the start edge of the item, snapping to the start scrolling
     * edge of the lazy list.
     */
    internal val Start: (SnapperLayoutInfo, SnapperLayoutItemInfo) -> Int =
        { layout, _ -> layout.startScrollOffset }

    /**
     * Snap offset which results in the item snapping in the center of the scrolling viewport
     * of the lazy list.
     */
    internal val Center: (SnapperLayoutInfo, SnapperLayoutItemInfo) -> Int = { layout, item ->
        layout.startScrollOffset + (layout.endScrollOffset - layout.startScrollOffset - item.size) / 2
    }

    /**
     * Snap offset which results in the end edge of the item, snapping to the end scrolling
     * edge of the lazy list.
     */
    internal val End: (SnapperLayoutInfo, SnapperLayoutItemInfo) -> Int = { layout, item ->
        layout.endScrollOffset - item.size
    }
}

/**
 * A snapping [FlingBehavior] for [LazyListState]. Typically this would be created
 * via [rememberSnapperFlingBehavior].
 *
 * Note: the default parameter value for [decayAnimationSpec] is different to the value used in
 * [rememberSnapperFlingBehavior], due to not being able to access composable functions.
 */
@ExperimentalSnapperApi
internal class SnapperFlingBehavior private constructor(
    private val layoutInfo: SnapperLayoutInfo,
    private val decayAnimationSpec: DecayAnimationSpec<Float>,
    private val springAnimationSpec: AnimationSpec<Float>,
    private val snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int,
    private val maximumFlingDistance: (SnapperLayoutInfo) -> Float,
) : FlingBehavior {
    /**
     * @param layoutInfo The [SnapperLayoutInfo] to use.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param springAnimationSpec The animation spec to use when snapping.
     * @param snapIndex Block which returns the index to snap to. The block is provided with the
     * [SnapperLayoutInfo], the index where the fling started, and the index which Snapper has
     * determined is the correct target index. Callers can override this value to any valid index
     * for the layout. Some common use cases include limiting the fling distance, and rounding
     * up/down to achieve snapping to groups of items.
     */
    internal constructor(
        layoutInfo: SnapperLayoutInfo,
        decayAnimationSpec: DecayAnimationSpec<Float>,
        springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int = SnapperFlingBehaviorDefaults.SnapIndex,
    ) : this(
        layoutInfo = layoutInfo,
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = springAnimationSpec,
        snapIndex = snapIndex,
        // We still need to pass in a maximumFlingDistance value
        maximumFlingDistance = @Suppress("DEPRECATION") SnapperFlingBehaviorDefaults.MaximumFlingDistance,
    )

    /**
     * @param layoutInfo The [SnapperLayoutInfo] to use.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param springAnimationSpec The animation spec to use when snapping.
     * @param maximumFlingDistance Block which returns the maximum fling distance in pixels.
     * The returned value should be > 0.
     */
    @Deprecated("The maximumFlingDistance parameter has been replaced with snapIndex")
    @Suppress("DEPRECATION")
    internal constructor(
        layoutInfo: SnapperLayoutInfo,
        decayAnimationSpec: DecayAnimationSpec<Float>,
        springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        maximumFlingDistance: (SnapperLayoutInfo) -> Float = SnapperFlingBehaviorDefaults.MaximumFlingDistance,
    ) : this(
        layoutInfo = layoutInfo,
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = springAnimationSpec,
        maximumFlingDistance = maximumFlingDistance,
        snapIndex = SnapperFlingBehaviorDefaults.SnapIndex,
    )

    /**
     * The target item index for any on-going animations.
     */
    internal var animationTarget: Int? by mutableStateOf(null)
        private set

    override suspend fun ScrollScope.performFling(
        initialVelocity: Float
    ): Float {
        // If we're at the start/end of the scroll range, we don't snap and assume the user
        // wanted to scroll here.
        if (!layoutInfo.canScrollTowardsStart() || !layoutInfo.canScrollTowardsEnd()) {
            return initialVelocity
        }

        val maxFlingDistance = maximumFlingDistance(layoutInfo)
        require(maxFlingDistance > 0) {
            "Distance returned by maximumFlingDistance should be greater than 0"
        }

        val initialItem = layoutInfo.currentItem ?: return initialVelocity

        val targetIndex = layoutInfo.determineTargetIndex(
            velocity = initialVelocity,
            decayAnimationSpec = decayAnimationSpec,
            maximumFlingDistance = maxFlingDistance,
        ).let { target ->
            // Let the snapIndex block transform the value
            snapIndex(
                layoutInfo,
                // If the user is flinging towards the index 0, we assume that the start item is
                // actually the next item (towards infinity).
                if (initialVelocity < 0) initialItem.index + 1 else initialItem.index,
                target,
            )
        }.also {
            require(it in 0 until layoutInfo.totalItemsCount)
        }

        return flingToIndex(index = targetIndex, initialVelocity = initialVelocity)
    }

    private suspend fun ScrollScope.flingToIndex(
        index: Int,
        initialVelocity: Float,
    ): Float {
        val initialItem = layoutInfo.currentItem ?: return initialVelocity

        if (initialItem.index == index && layoutInfo.distanceToIndexSnap(initialItem.index) == 0) {
            return consumeVelocityIfNotAtScrollEdge(initialVelocity)
        }

        var velocityLeft = initialVelocity

        if (decayAnimationSpec.canDecayBeyondCurrentItem(initialVelocity, initialItem)) {
            // If the decay fling can scroll past the current item, start with a decayed fling
            velocityLeft = performDecayFling(
                initialItem = initialItem,
                targetIndex = index,
                initialVelocity = velocityLeft,
            )
        }

        val currentItem = layoutInfo.currentItem ?: return initialVelocity
        if (currentItem.index != index || layoutInfo.distanceToIndexSnap(index) != 0) {
            // If we're not at the target index yet, spring to it
            velocityLeft = performSpringFling(
                initialItem = currentItem,
                targetIndex = index,
                initialVelocity = velocityLeft,
            )
        }

        return consumeVelocityIfNotAtScrollEdge(velocityLeft)
    }

    /**
     * Performs a decaying fling.
     *
     * If [flingThenSpring] is set to true, then a fling-then-spring animation might be used.
     * If used, a decay fling will be run until we've scrolled to the preceding item of
     * [targetIndex]. Once that happens, the decay animation is stopped and a spring animation
     * is started to scroll the remainder of the distance. Visually this results in a much
     * smoother finish to the animation, as it will slowly come to a stop at [targetIndex].
     * Even if [flingThenSpring] is set to true, fling-then-spring animations are only available
     * when scrolling 2 items or more.
     *
     * When [flingThenSpring] is not used, the decay animation will be stopped immediately upon
     * scrolling past [targetIndex], which can result in an abrupt stop.
     */
    private suspend fun ScrollScope.performDecayFling(
        initialItem: SnapperLayoutItemInfo,
        targetIndex: Int,
        initialVelocity: Float,
        flingThenSpring: Boolean = true,
    ): Float {
        // If we're already at the target + snap offset, skip
        if (initialItem.index == targetIndex && layoutInfo.distanceToIndexSnap(initialItem.index) == 0) {
            return consumeVelocityIfNotAtScrollEdge(initialVelocity)
        }

        var velocityLeft = initialVelocity
        var lastValue = 0f

        // We can only fling-then-spring if we're flinging >= 2 items...
        val canSpringThenFling = flingThenSpring && abs(targetIndex - initialItem.index) >= 2

        try {
            // Update the animationTarget
            animationTarget = targetIndex

            AnimationState(
                initialValue = 0f,
                initialVelocity = initialVelocity,
            ).animateDecay(decayAnimationSpec) {
                val delta = value - lastValue
                val consumed = scrollBy(delta)
                lastValue = value
                velocityLeft = velocity

                if (abs(delta - consumed) > 0.5f) {
                    // If some of the scroll was not consumed, cancel the animation now as we're
                    // likely at the end of the scroll range
                    cancelAnimation()
                }

                val currentItem = layoutInfo.currentItem
                if (currentItem == null) {
                    cancelAnimation()
                    return@animateDecay
                }

                if (isRunning && canSpringThenFling) {
                    // If we're still running and fling-then-spring is enabled, check to see
                    // if we're at the 1 item width away (in the relevant direction). If we are,
                    // cancel the current decay and let flingToIndex() start a spring
                    if (velocity > 0 && currentItem.index == targetIndex - 1) {
                        cancelAnimation()
                    } else if (velocity < 0 && currentItem.index == targetIndex) {
                        cancelAnimation()
                    }
                }

                if (isRunning && performSnapBackIfNeeded(currentItem, targetIndex, ::scrollBy)) {
                    // If we're still running, check to see if we need to snap-back
                    // (if we've scrolled past the target)
                    cancelAnimation()
                }
            }
        } finally {
            animationTarget = null
        }

        return velocityLeft
    }

    private suspend fun ScrollScope.performSpringFling(
        initialItem: SnapperLayoutItemInfo,
        targetIndex: Int,
        initialVelocity: Float = 0f,
    ): Float {
        var velocityLeft = when {
            // Only use the initialVelocity if it is in the correct direction
            targetIndex > initialItem.index && initialVelocity > 0 -> initialVelocity
            targetIndex <= initialItem.index && initialVelocity < 0 -> initialVelocity
            // Otherwise start at 0 velocity
            else -> 0f
        }
        var lastValue = 0f

        try {
            // Update the animationTarget
            animationTarget = targetIndex

            AnimationState(
                initialValue = lastValue,
                initialVelocity = velocityLeft,
            ).animateTo(
                targetValue = layoutInfo.distanceToIndexSnap(targetIndex).toFloat(),
                animationSpec = springAnimationSpec,
            ) {
                val delta = value - lastValue
                val consumed = scrollBy(delta)
                lastValue = value
                velocityLeft = velocity

                val currentItem = layoutInfo.currentItem
                if (currentItem == null) {
                    cancelAnimation()
                    return@animateTo
                }

                if (performSnapBackIfNeeded(currentItem, targetIndex, ::scrollBy)) {
                    cancelAnimation()
                } else if (abs(delta - consumed) > 0.5f) {
                    // If we're still running but some of the scroll was not consumed,
                    // cancel the animation now
                    cancelAnimation()
                }
            }
        } finally {
            animationTarget = null
        }

        return velocityLeft
    }

    /**
     * Returns true if we needed to perform a snap back, and the animation should be cancelled.
     */
    private fun AnimationScope<Float, AnimationVector1D>.performSnapBackIfNeeded(
        currentItem: SnapperLayoutItemInfo,
        targetIndex: Int,
        scrollBy: (pixels: Float) -> Float,
    ): Boolean {

        // Calculate the 'snap back'. If the returned value is 0, we don't need to do anything.
        val snapBackAmount = calculateSnapBack(velocity, currentItem, targetIndex)

        if (snapBackAmount != 0) {
            // If we've scrolled to/past the item, stop the animation. We may also need to
            // 'snap back' to the item as we may have scrolled past it
            scrollBy(snapBackAmount.toFloat())
            return true
        }

        return false
    }

    private fun DecayAnimationSpec<Float>.canDecayBeyondCurrentItem(
        velocity: Float,
        currentItem: SnapperLayoutItemInfo,
    ): Boolean {
        // If we don't have a velocity, return false
        if (velocity.absoluteValue < 0.5f) return false

        val flingDistance = calculateTargetValue(0f, velocity)

        return if (velocity < 0) {
            // backwards, towards 0
            flingDistance <= layoutInfo.distanceToIndexSnap(currentItem.index)
        } else {
            // forwards, toward index + 1
            flingDistance >= layoutInfo.distanceToIndexSnap(currentItem.index + 1)
        }
    }

    /**
     * Returns the distance in pixels that is required to 'snap back' to the [targetIndex].
     * Returns 0 if a snap back is not needed.
     */
    private fun calculateSnapBack(
        initialVelocity: Float,
        currentItem: SnapperLayoutItemInfo,
        targetIndex: Int,
    ): Int = when {
        // forwards
        initialVelocity > 0 && currentItem.index >= targetIndex -> {
            layoutInfo.distanceToIndexSnap(currentItem.index)
        }
        initialVelocity < 0 && currentItem.index <= targetIndex - 1 -> {
            layoutInfo.distanceToIndexSnap(currentItem.index + 1)
        }
        else -> 0
    }

    private fun consumeVelocityIfNotAtScrollEdge(velocity: Float): Float {
        if (velocity < 0 && !layoutInfo.canScrollTowardsStart()) {
            // If there is remaining velocity towards the start and we're at the scroll start,
            // we don't consume. This enables the overscroll effect where supported
            return velocity
        } else if (velocity > 0 && !layoutInfo.canScrollTowardsEnd()) {
            // If there is remaining velocity towards the end and we're at the scroll end,
            // we don't consume. This enables the overscroll effect where supported
            return velocity
        }
        // Else we return 0 to consume the remaining velocity
        return 0f
    }
}

/**
 * Create and remember a snapping [FlingBehavior] to be used with [LazyListState].
 *
 * This is a convenience function for using [rememberLazyListSnapperLayoutInfo] and
 * [rememberSnapperFlingBehavior]. If you require access to the layout info, you can safely use
 * those APIs directly.
 *
 * @param lazyListState The [LazyListState] to update.
 * @param snapOffsetForItem Block which returns which offset the given item should 'snap' to.
 * See [SnapOffsets] for provided values.
 * @param decayAnimationSpec The decay animation spec to use for decayed flings.
 * @param springAnimationSpec The animation spec to use when snapping.
 * @param snapIndex Block which returns the index to snap to. The block is provided with the
 * [SnapperLayoutInfo], the index where the fling started, and the index which Snapper has
 * determined is the correct target index. Callers can override this value to any valid index
 * for the layout. Some common use cases include limiting the fling distance, and rounding up/down
 * to achieve snapping to groups of items.
 */
@ExperimentalSnapperApi
@Composable
internal fun rememberSnapperFlingBehavior(
    lazyListState: LazyListState,
    snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int = SnapOffsets.Center,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
    snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int = SnapperFlingBehaviorDefaults.SnapIndex,
): SnapperFlingBehavior = rememberSnapperFlingBehavior(
    layoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState, snapOffsetForItem),
    decayAnimationSpec = decayAnimationSpec,
    springAnimationSpec = springAnimationSpec,
    snapIndex = snapIndex,
)

@Deprecated(
    "endContentPadding is no longer necessary to be passed in",
    ReplaceWith("rememberSnapperFlingBehavior(lazyListState, snapOffsetForItem, decayAnimationSpec, springAnimationSpec, snapIndex)")
)
@ExperimentalSnapperApi
@Composable
internal fun rememberSnapperFlingBehavior(
    lazyListState: LazyListState,
    snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int = SnapOffsets.Center,
    @Suppress("UNUSED_PARAMETER") endContentPadding: Dp = 0.dp,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
    snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int = SnapperFlingBehaviorDefaults.SnapIndex,
): SnapperFlingBehavior = rememberSnapperFlingBehavior(
    layoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState, snapOffsetForItem),
    decayAnimationSpec = decayAnimationSpec,
    springAnimationSpec = springAnimationSpec,
    snapIndex = snapIndex,
)

@Composable
@Deprecated("The maximumFlingDistance parameter has been replaced with snapIndex")
@Suppress("DEPRECATION")
@ExperimentalSnapperApi
internal fun rememberSnapperFlingBehavior(
    lazyListState: LazyListState,
    snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int = SnapOffsets.Center,
    endContentPadding: Dp = 0.dp,
    decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
    springAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
    maximumFlingDistance: (SnapperLayoutInfo) -> Float,
): SnapperFlingBehavior = rememberSnapperFlingBehavior(
    layoutInfo = rememberLazyListSnapperLayoutInfo(
        lazyListState = lazyListState,
        snapOffsetForItem = snapOffsetForItem,
        endContentPadding = endContentPadding
    ),
    decayAnimationSpec = decayAnimationSpec,
    springAnimationSpec = springAnimationSpec,
    maximumFlingDistance = maximumFlingDistance,
)

/**
 * Create and remember a [SnapperLayoutInfo] which works with [LazyListState].
 *
 * @param lazyListState The [LazyListState] to update.
 * @param snapOffsetForItem Block which returns which offset the given item should 'snap' to.
 * See [SnapOffsets] for provided values.
 */
@Deprecated(
    "endContentPadding is no longer necessary to be passed in",
    ReplaceWith("rememberLazyListSnapperLayoutInfo(lazyListState, snapOffsetForItem)")
)
@ExperimentalSnapperApi
@Composable
internal fun rememberLazyListSnapperLayoutInfo(
    lazyListState: LazyListState,
    snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int = SnapOffsets.Center,
    @Suppress("UNUSED_PARAMETER") endContentPadding: Dp = 0.dp,
): LazyListSnapperLayoutInfo {
    return rememberLazyListSnapperLayoutInfo(lazyListState, snapOffsetForItem)
}

/**
 * Create and remember a [SnapperLayoutInfo] which works with [LazyListState].
 *
 * @param lazyListState The [LazyListState] to update.
 * @param snapOffsetForItem Block which returns which offset the given item should 'snap' to.
 * See [SnapOffsets] for provided values.
 */
@ExperimentalSnapperApi
@Composable
internal fun rememberLazyListSnapperLayoutInfo(
    lazyListState: LazyListState,
    snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int = SnapOffsets.Center,
): LazyListSnapperLayoutInfo = remember(lazyListState, snapOffsetForItem) {
    LazyListSnapperLayoutInfo(
        lazyListState = lazyListState,
        snapOffsetForItem = snapOffsetForItem,
    )
}

/**
 * A [SnapperLayoutInfo] which works with [LazyListState]. Typically this would be remembered
 * using [rememberLazyListSnapperLayoutInfo].
 *
 * @param lazyListState The [LazyListState] to update.
 * @param snapOffsetForItem Block which returns which offset the given item should 'snap' to.
 * See [SnapOffsets] for provided values.
 */
@ExperimentalSnapperApi
internal class LazyListSnapperLayoutInfo(
    private val lazyListState: LazyListState,
    private val snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int,
) : SnapperLayoutInfo() {

    @Deprecated(
        "endContentPadding is no longer necessary to be passed in",
        ReplaceWith("LazyListSnapperLayoutInfo(lazyListState, snapOffsetForItem)")
    )
    internal constructor(
        lazyListState: LazyListState,
        snapOffsetForItem: (layoutInfo: SnapperLayoutInfo, item: SnapperLayoutItemInfo) -> Int,
        @Suppress("UNUSED_PARAMETER") endContentPadding: Int = 0,
    ) : this(lazyListState, snapOffsetForItem)

    /**
     * Lazy lists always use 0 as the start scroll offset (within content padding)
     */
    override val startScrollOffset: Int = 0

    /**
     * viewportEndOffset is the last visible offset, so we need to remove any end content padding
     * to get the end of the scroll range
     */
    override val endScrollOffset: Int
        get() = lazyListState.layoutInfo.let { it.viewportEndOffset - it.afterContentPadding }

    private val itemCount: Int get() = lazyListState.layoutInfo.totalItemsCount

    override val totalItemsCount: Int
        get() = lazyListState.layoutInfo.totalItemsCount

    override val currentItem: SnapperLayoutItemInfo? by derivedStateOf {
        visibleItems.lastOrNull { it.offset <= snapOffsetForItem(this, it) }
    }

    override val visibleItems: Sequence<SnapperLayoutItemInfo>
        get() = lazyListState.layoutInfo.visibleItemsInfo.asSequence()
            .map(::LazyListSnapperLayoutItemInfo)

    override fun distanceToIndexSnap(index: Int): Int {
        val itemInfo = visibleItems.firstOrNull { it.index == index }
        if (itemInfo != null) {
            // If we have the item visible, we can calculate using the offset. Woop.
            return itemInfo.offset - snapOffsetForItem(this, itemInfo)
        }

        // Otherwise we need to guesstimate, using the current item snap point and
        // multiplying distancePerItem by the index delta
        val currentItem = currentItem ?: return 0 // TODO: throw?
        return ((index - currentItem.index) * estimateDistancePerItem()).roundToInt() +
                currentItem.offset -
                snapOffsetForItem(this, currentItem)
    }

    override fun canScrollTowardsStart(): Boolean {
        return lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.let {
            it.index > 0 || it.offset < startScrollOffset
        } ?: false
    }

    override fun canScrollTowardsEnd(): Boolean {
        return lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.let {
            it.index < itemCount - 1 || (it.offset + it.size) > endScrollOffset
        } ?: false
    }

    override fun determineTargetIndex(
        velocity: Float,
        decayAnimationSpec: DecayAnimationSpec<Float>,
        maximumFlingDistance: Float,
    ): Int {
        val curr = currentItem ?: return -1

        val distancePerItem = estimateDistancePerItem()
        if (distancePerItem <= 0) {
            // If we don't have a valid distance, return the current item
            return curr.index
        }

        val distanceToCurrent = distanceToIndexSnap(curr.index)
        val distanceToNext = distanceToIndexSnap(curr.index + 1)

        if (abs(velocity) < 0.5f) {
            // If we don't have a velocity, target whichever item is closer
            return when {
                distanceToCurrent.absoluteValue < distanceToNext.absoluteValue -> curr.index
                else -> curr.index + 1
            }.coerceIn(0, itemCount - 1)
        }

        // Otherwise we calculate using the velocity
        val flingDistance = decayAnimationSpec.calculateTargetValue(0f, velocity)
            .coerceIn(-maximumFlingDistance, maximumFlingDistance)
            .let { distance ->
                // It's likely that the user has already scrolled an amount before the fling
                // has been started. We compensate for that by removing the scrolled distance
                // from the calculated fling distance. This is necessary so that we don't fling
                // past the max fling distance.
                if (velocity < 0) {
                    (distance + distanceToNext).coerceAtMost(0f)
                } else {
                    (distance + distanceToCurrent).coerceAtLeast(0f)
                }
            }

        val flingIndexDelta = flingDistance / distancePerItem.toDouble()
        val currentItemOffsetRatio = distanceToCurrent / distancePerItem.toDouble()

        // The index offset from the current index. We round this value which results in
        // flings rounding towards the (relative) infinity. The key use case for this is to
        // support short + fast flings. These could result in a fling distance of ~70% of the
        // item distance (example). The rounding ensures that we target the next page.
        val indexOffset = (flingIndexDelta - currentItemOffsetRatio).roundToInt()

        return (curr.index + indexOffset).coerceIn(0, itemCount - 1)
    }

    /**
     * This attempts to calculate the item spacing for the layout, by looking at the distance
     * between the visible items. If there's only 1 visible item available, it returns 0.
     */
    private fun calculateItemSpacing(): Int = with(lazyListState.layoutInfo) {
        if (visibleItemsInfo.size >= 2) {
            val first = visibleItemsInfo[0]
            val second = visibleItemsInfo[1]
            second.offset - (first.size + first.offset)
        } else 0
    }

    /**
     * Computes an average pixel value to pass a single child.
     *
     * Returns a negative value if it cannot be calculated.
     *
     * @return A float value that is the average number of pixels needed to scroll by one view in
     * the relevant direction.
     */
    private fun estimateDistancePerItem(): Float = with(lazyListState.layoutInfo) {
        if (visibleItemsInfo.isEmpty()) return -1f

        val minPosView = visibleItemsInfo.minByOrNull { it.offset } ?: return -1f
        val maxPosView = visibleItemsInfo.maxByOrNull { it.offset + it.size } ?: return -1f

        val start = min(minPosView.offset, maxPosView.offset)
        val end = max(minPosView.offset + minPosView.size, maxPosView.offset + maxPosView.size)

        // We add an extra `itemSpacing` onto the calculated total distance. This ensures that
        // the calculated mean contains an item spacing for each visible item
        // (not just spacing between items)
        return when (val distance = end - start) {
            0 -> -1f // If we don't have a distance, return -1
            else -> (distance + calculateItemSpacing()) / visibleItemsInfo.size.toFloat()
        }
    }
}

private class LazyListSnapperLayoutItemInfo(
    private val lazyListItem: LazyListItemInfo,
) : SnapperLayoutItemInfo() {
    override val index: Int get() = lazyListItem.index
    override val offset: Int get() = lazyListItem.offset
    override val size: Int get() = lazyListItem.size
}