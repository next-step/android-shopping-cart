package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.common.component.Stepper
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class StepperTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val count = mutableStateOf(1)
    private val minimum = 0
    private val maximum = 100
    private val step = 1

    @Before
    fun setup() {
        composeTestRule.setContent {
            Stepper(
                count = count.value,
                onChangeCount = {
                    count.value = it
                },
                minimum = minimum,
                maximum = maximum,
                step = step,
            )
        }
    }

    @Test
    fun 마이너스_버튼을_누르면_step만큼_수량이_감소한다() {
        // given
        count.value = 1

        // when
        composeTestRule.onNodeWithText("−").performClick()

        // then
        assertTrue(count.value == 0)
        composeTestRule.onNodeWithText("0").assertExists()
    }

    @Test
    fun 플러스_버튼을_누르면_step만큼_수량이_증가한다() {
        // given
        count.value = 1

        // when
        composeTestRule.onNodeWithText("+").performClick()

        // then
        assertTrue(count.value == 2)
        composeTestRule.onNodeWithText("2").assertExists()
    }

    @Test
    fun 숫자가_이미_minimum값이면_더_감소하지_않는다() {
        // given
        count.value = minimum

        // when
        composeTestRule.onNodeWithText("−").performClick()

        // then
        assertTrue(count.value == 0)
        composeTestRule.onNodeWithText("0").assertExists()
    }

    @Test
    fun 숫자가_이미_maximum값이면_더_증가하지_않는다() {
        // given
        count.value = maximum

        // when
        composeTestRule.onNodeWithText("+").performClick()

        // then
        assertTrue(count.value == 100)
        composeTestRule.onNodeWithText("100").assertExists()
    }
}
