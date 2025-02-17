package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
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

    private val addButton get() = composeTestRule.onNodeWithContentDescription("담기")
    private val removeButton get() = composeTestRule.onNodeWithContentDescription("제거")
    private var count by mutableIntStateOf(initCount)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CountControlButton(
                count = count,
                onAddClick = { count = count.inc() },
                onRemoveClick = { count = count.dec() },
            )
        }
    }

    @Test
    fun 담기_숫자_제거_버튼_노출() {
        // then
        addButton.assertIsDisplayed()
        composeTestRule
            .onNodeWithText("3")
            .assertIsDisplayed()
        removeButton.assertIsDisplayed()
    }

    @Test
    fun 담기_버튼_클릭시_카운트_증가() {
        // when
        addButton.assertIsDisplayed()
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("4")
            .assertIsDisplayed()
    }

    @Test
    fun 제거_버튼_클릭시_카운트_감소() {
        // when
        removeButton
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("2")
            .assertIsDisplayed()
    }

    @Test
    fun 제거_버튼_다중_클릭으로_0미만_카운트_일때_0_노출_되고_제거버튼_비활성화() {
        // when
        repeat(initCount + 10) {
            removeButton
                .performClick()
        }

        // then
        composeTestRule
            .onNodeWithText("0")
            .assertIsDisplayed()
        removeButton
            .assertIsNotEnabled()
    }
}