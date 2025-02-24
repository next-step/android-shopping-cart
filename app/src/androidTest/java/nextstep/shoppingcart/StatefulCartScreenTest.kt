package nextstep.shoppingcart

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.Cart
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.UUID

internal class StatefulCartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        Cart.clear()
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    onBackPressed = {},
                    onButtonClick = {},
                )
            }
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // when
        Cart.addOne(dummyProduct())

        // then
        val formatedTotalPrice = String.format("%,d", Cart.totalPrice)
        composeTestRule
            .onNodeWithText("주문하기(${formatedTotalPrice}원)")
            .assertExists()
    }


    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given
        val product = dummyProduct()
        Cart.addOne(product)

        // when
        composeTestRule.onNodeWithTag("삭제").performClick()

        // then
        composeTestRule.onNodeWithText(product.name).assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        val product = dummyProduct()
        Cart.addOne(product)

        // when
        composeTestRule.onNodeWithTag("+").performClick()

        // then
        val productPrice = product.price * Cart.items.find { it.product.id == product.id }?.count!!
        composeTestRule.onNodeWithTag("상품 가격")
            .assert(hasText("${String.format("%,d", productPrice)}원"))
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        val product = dummyProduct()
        Cart.addOne(product)
        Cart.addOne(product)

        // when
        composeTestRule.onNodeWithTag("-").performClick()

        // then
        val productPrice = product.price * Cart.items.find { it.product.id == product.id }?.count!!
        composeTestRule.onNodeWithTag("상품 가격")
            .assert(hasText("${String.format("%,d", productPrice)}원"))
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        val product = dummyProduct()
        Cart.addOne(product)

        // when
        composeTestRule.onNodeWithTag("-").performClick()

        // then
        composeTestRule.onNodeWithText(product.name).assertDoesNotExist()
    }


    companion object {
        private fun dummyProduct(
            name: String = "매콤달콤 떡볶이!",
            price: Int = 8500
        ) = Product(
            id = UUID.randomUUID().toString(),
            "",
            name,
            price
        )
    }
}