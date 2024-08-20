package nextstep.shoppingcart.cart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.dummyProducts
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val cart = Cart

    @Before
    fun setup() {
        cart.clear()
        dummyProducts.forEach {
            cart.addOne(it)
        }
    }

    @Test
    fun 장바구니에서_모든_품목들의_합이_표기된다() {
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
        val expectedTotalPrice =
            NumberFormat.getNumberInstance(Locale.KOREA).format(cart.totalPrice)

        composeTestRule
            .onNodeWithText("주문하기(${expectedTotalPrice}원)")
            .assertIsDisplayed()
    }
}