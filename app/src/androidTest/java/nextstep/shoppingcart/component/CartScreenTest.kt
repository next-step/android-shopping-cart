package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.screen.ShoppingCartScreen
import nextstep.shoppingcart.util.Cart
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        Cart.cleatCart()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        //GIVEN
        Cart.addOne(product = productList[0])
        Cart.addOne(product = productList[1])
        Cart.addOne(product = productList[1])

        composeTestRule.setContent {
            ShoppingCartScreen(
                onBackClick = { }
            )
        }

        //WHEN

        //THEN
        composeTestRule
            .onNodeWithTag("ShoppingTextButton")
            .assertTextContains("주문하기(2,065,000원)")
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        //GIVEN
        Cart.addOne(product = productList[0])

        composeTestRule.setContent {
            ShoppingCartScreen(
                onBackClick = { }
            )
        }

        //WHEN
        composeTestRule.onNodeWithTag("CartItemClose").performClick()

        //THEN
        composeTestRule
            .onNodeWithText(productList[0].name)
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        //GIVEN
        Cart.addOne(product = productList[0])

        composeTestRule.setContent {
            ShoppingCartScreen(
                onBackClick = { }
            )
        }

        //WHEN
        composeTestRule.onNodeWithTag("CartItemPlus").performClick()

        //THEN
        composeTestRule
            .onNodeWithTag("ShoppingTextButton")
            .assertTextContains("주문하기(4,000,000원)")
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        //GIVEN
        Cart.addOne(product = productList[0])
        Cart.addOne(product = productList[0])

        composeTestRule.setContent {
            ShoppingCartScreen(
                onBackClick = { }
            )
        }

        //WHEN
        composeTestRule.onNodeWithTag("CartItemMinus").performClick()

        //THEN
        composeTestRule
            .onNodeWithTag("ShoppingTextButton")
            .assertTextContains("주문하기(2,000,000원)")
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        //GIVEN
        Cart.addOne(product = productList[0])

        composeTestRule.setContent {
            ShoppingCartScreen(
                onBackClick = { }
            )
        }

        //WHEN
        composeTestRule.onNodeWithTag("CartItemMinus").performClick()

        //THEN
        composeTestRule
            .onNodeWithText(productList[0].name)
            .assertDoesNotExist()
    }
}