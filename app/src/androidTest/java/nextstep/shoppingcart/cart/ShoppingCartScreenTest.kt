package nextstep.shoppingcart.cart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.shopping.cart.ShoppingCartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = Product(
        id = 1,
        name = "iPhone 15",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 10000
    )

    @Before
    fun setUp() {
        Cart.removeAll(product)
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        Cart.addOne(product)

        // when
        composeTestRule.setContent {
            ShoppingCartScreen(onClickNavigateBack = {})
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(10,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given
        Cart.addOne(product)

        // when
        composeTestRule.setContent {
            ShoppingCartScreen(onClickNavigateBack = {})
        }

        // then
        composeTestRule
            .onNodeWithContentDescription("삭제 버튼")
            .performClick()
        composeTestRule
            .onNodeWithText("iPhone 15")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        Cart.addOne(product)

        // when
        composeTestRule.setContent {
            ShoppingCartScreen(onClickNavigateBack = {})
        }
        composeTestRule
            .onNodeWithText("+")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("주문하기(20,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        Cart.addOne(product)

        // when
        composeTestRule.setContent {
            ShoppingCartScreen(onClickNavigateBack = {})
        }
        composeTestRule
            .onNodeWithText("-")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("주문하기(0원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        Cart.addOne(product)

        // when
        composeTestRule.setContent {
            ShoppingCartScreen(onClickNavigateBack = {})
        }
        composeTestRule
            .onNodeWithText("-")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("iPhone 15")
            .assertDoesNotExist()
    }
}
