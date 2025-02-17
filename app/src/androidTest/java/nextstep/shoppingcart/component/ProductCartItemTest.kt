package nextstep.shoppingcart.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductCartItem
import org.junit.Rule
import org.junit.Test

class ProductCartItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `담은_상품의_갯수에맞는_가격을_보여준다`() {
        val cartItem =
            CartItem(
                product = Product(0, "", "상품", 1000),
                count = 2
            )

        composeTestRule.setContent {
            ProductCartItem(
                cartItem = cartItem,
                onRemoveClick = {},
                onIncreaseClick = {},
                onDecreaseClick = {}
            )
        }

        composeTestRule
            .onNodeWithText("2,000원")
            .assertIsDisplayed()
    }

    @Test
    fun `상품의_갯수는_1개_이하로_내려가지_않는다`() {
        // given
        val cartItem = CartItem(
            product = Product(0, "", "상품", 1000),
            count = 2
        )
        composeTestRule.setContent {
            var cartItemState by remember {
                mutableStateOf(cartItem)
            }
            ProductCartItem(
                cartItem = cartItemState,
                onRemoveClick = {},
                onIncreaseClick = {
                    cartItemState = cartItemState.copy(count = cartItemState.count.inc())
                },
                onDecreaseClick = {
                    cartItemState = cartItemState.copy(count = cartItemState.count.dec())
                }
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("상품_decrease_button")
            .performClick()
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("상품_count")
            .assertTextEquals("1")
    }
}
