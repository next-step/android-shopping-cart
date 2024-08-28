package nextstep.shoppingcart.cart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val cart = Cart

    @Before
    fun setup() {
        cart.clear()
    }

    @Test
    fun 장바구니에서_모든_품목들의_합이_표기된다() {
        cart.apply {
            addOne(
                product = Product(
                    id = "",
                    name = "",
                    price = 1000,
                    imageUrl = null,
                )
            )
            addOne(
                product = Product(
                    id = "",
                    name = "",
                    price = 1000,
                    imageUrl = null,
                )
            )
        }

        // given
        composeTestRule.setContent {
            CartScreen(
                cartItems = cart.items,
                totalPrice = cart.totalPrice,
                onCountAddClick = {},
                onCountMinusClick = {},
                onCartItemDeleteClick = {},
                onBackClick = {},
            )
        }

        // then
        val expectedTotalPrice = "2,000"
        composeTestRule
            .onNodeWithText("주문하기(${expectedTotalPrice}원)")
            .assertIsDisplayed()
    }
}