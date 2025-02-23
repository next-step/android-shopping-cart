package nextstep.shoppingcart.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ShoppingCartCounterTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 더하기_버튼을_누르면_수가_증가한다() {
        // given
        var count = 1

        composeTestRule.setContent {
            ShoppingCartCounter(
                count = count,
                onAddClick = { count++ },
                onRemoveClick = { count-- },
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("더하기").performClick()

        // then
        assert(count == 2)
    }

    @Test
    fun 빼기_버튼을_누르면_수가_감소한다() {
        // given
        var count = 0

        composeTestRule.setContent {
            ShoppingCartCounter(
                count = count,
                onAddClick = { count++ },
                onRemoveClick = { count-- },
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("빼기").performClick()

        // then
        assert(count == -1)
    }
}
