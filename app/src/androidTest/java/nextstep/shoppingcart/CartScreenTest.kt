package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.cart.component.CartProductItem
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        val cartItem = CartItem(
            product = Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imageUrl = "",
            ),
            count = 100
        )

        // when
        composeTestRule.setContent {
            CartProductItem(
                cartItem = cartItem,
                onClickDeleteItemButton = {},
                onClickIncreaseCountButton = {},
                onClickDecreaseCountButton = {},
            )
        }

        // then
        composeTestRule.onNodeWithText("100,000원")
            .assertExists()
    }

}
