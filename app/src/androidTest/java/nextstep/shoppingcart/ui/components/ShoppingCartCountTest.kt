package nextstep.shoppingcart.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.CartCount
import org.junit.Rule
import org.junit.Test

class ShoppingCartCountTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 더하기_버튼을_누르면_수가_증가한다() {
        // given
        var cartCount = CartCount.INIT_COUNT

        composeTestRule.setContent {
            ShoppingCartCounter(
                counter = cartCount,
                onAddClick = { cartCount++ },
                onRemoveClick = {},
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("더하기").performClick()

        // then
        assert(cartCount.value == 2)
    }

    @Test
    fun 빼기_버튼을_누르면_수가_감소한다() {
        // given
        var counter = CartCount(3)

        composeTestRule.setContent {
            ShoppingCartCounter(
                counter = counter,
                onAddClick = {},
                onRemoveClick = { counter-- }
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("빼기").performClick()

        // then
        assert(counter.value == 2)
    }

    @Test
    fun 수가_1이면_빼기_버튼을_눌러도_감소하지_않는다() {
        // given
        var counter = CartCount.INIT_COUNT

        composeTestRule.setContent {
            ShoppingCartCounter(
                counter = CartCount.INIT_COUNT,
                onAddClick = {},
                onRemoveClick = { counter-- },
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("빼기").performClick()

        // then
        assert(counter.value == 1)
    }
}
