package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountControlButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val initCount = 3
    private var count by mutableIntStateOf(initCount)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CountControlButton(
                count = count,
                countUpdate = { count = it }
            )
        }
    }

    @Test
    fun 담기_숫자_제거_버튼_노출() {
        // then
        composeTestRule
            .onNodeWithContentDescription("담기")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("$initCount")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("제거")
            .assertIsDisplayed()
    }

    @Test
    fun 담기_버튼_클릭시_카운트_증가() {
        // when
        composeTestRule
            .onNodeWithContentDescription("담기")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("${initCount.inc()}")
            .assertIsDisplayed()
    }

    @Test
    fun 제거_버튼_클릭시_카운트_감소() {
        // when
        composeTestRule
            .onNodeWithContentDescription("제거")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("${initCount.dec()}")
            .assertIsDisplayed()
    }

    @Test
    fun 제거_버튼_클릭시_0미만으로는_숫자_감소되지_않고_0으로_노출() {
        // when
        val clickCount = initCount + 2
        composeTestRule
            .onNodeWithContentDescription("제거")
            .let { node ->
                repeat(clickCount) { node.performClick() }
            }

        // then
        composeTestRule
            .onNodeWithText("${initCount - clickCount}")
            .assertIsNotDisplayed()
        composeTestRule
            .onNodeWithText("0")
            .assertIsDisplayed()
    }
}