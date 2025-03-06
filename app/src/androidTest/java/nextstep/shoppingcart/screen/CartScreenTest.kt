package nextstep.shoppingcart.screen

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.utils.formatPrice
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        // given
        Cart.clearAll()
        Cart.addOne(Product.mock)
        Cart.addOne(Product.mock)
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onClickBack = { },
                    onClickOrder = { },
                )
            }
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // then
        composeTestRule
            .onNodeWithText("주문하기(${Cart.totalPrice.formatPrice()})")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // when
        composeTestRule
            .onNodeWithTag("remove")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText(Product.mock.name)
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {

        // when
        composeTestRule
            .onNodeWithText("+")
            .performClick()

        // then
        val newPrice = Product.mock.price * Cart.getCount(Product.mock)
        composeTestRule
            .onNodeWithTag("price")
            .assertTextEquals(newPrice.formatPrice())
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // when
        composeTestRule
            .onNodeWithText("-")
            .performClick()

        // then
        val newPrice = Product.mock.price * Cart.getCount(Product.mock)
        composeTestRule
            .onNodeWithTag("price")
            .assertTextEquals(newPrice.formatPrice())
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {

        // when
        composeTestRule
            .onNodeWithText("-")
            .performClick()
            .performClick()

        // then
        composeTestRule
            .onNodeWithText(Product.mock.name)
            .assertDoesNotExist()
    }
}