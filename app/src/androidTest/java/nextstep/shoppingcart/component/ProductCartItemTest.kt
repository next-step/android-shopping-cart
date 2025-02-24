package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
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
}
