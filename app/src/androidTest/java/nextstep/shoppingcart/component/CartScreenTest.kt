package nextstep.shoppingcart.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.screen.ShoppingCartScreen
import nextstep.shoppingcart.util.Cart
import okhttp3.internal.wait
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        //GIVEN
        val cartItemList by mutableStateOf(
            listOf(
                CartItem(product = productList[0], count = 1),
                CartItem(product = productList[1], count = 2)
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItemList = cartItemList,
                totalAmount = cartItemList.sumOf { it.totalPrice },
                onPlusClick = { },
                onMinusClick = { },
                onCloseClick = { },
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
        var cartItemList by mutableStateOf(
            listOf(
                CartItem(product = productList[0], count = 1)
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItemList = cartItemList,
                totalAmount = cartItemList.sumOf { it.totalPrice },
                onPlusClick = { },
                onMinusClick = { },
                onCloseClick = { cartItem ->
                    cartItemList = cartItemList.filterNot {
                        it.product.id == cartItem.product.id
                    }
                },
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
        var cartItemList by mutableStateOf(
            listOf(
                CartItem(product = productList[0], count = 1)
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItemList = cartItemList,
                totalAmount = cartItemList.sumOf { it.totalPrice },
                onPlusClick = { cartItem ->
                    cartItemList = cartItemList.map { item ->
                        if (cartItem.product.id == item.product.id) item.copy(count = item.count + 1)
                        else item
                    }
                },
                onMinusClick = { },
                onCloseClick = { },
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
        var cartItemList by mutableStateOf(
            listOf(
                CartItem(product = productList[0], count = 2)
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItemList = cartItemList,
                totalAmount = cartItemList.sumOf { it.totalPrice },
                onPlusClick = { },
                onMinusClick = { cartItem ->
                    cartItemList = cartItemList.map { item ->
                        if (cartItem.product.id == item.product.id) item.copy(count = item.count - 1)
                        else item
                    }
                },
                onCloseClick = { },
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
        var cartItemList by mutableStateOf(
            listOf(
                CartItem(product = productList[0], count = 1)
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItemList = cartItemList,
                totalAmount = cartItemList.sumOf { it.totalPrice },
                onPlusClick = { },
                onMinusClick = { cartItem ->
                    cartItemList = cartItemList.filterNot { item ->
                        item.count <= 1
                    }.map { item ->
                        if (cartItem.product.id == item.product.id) item.copy(count = item.count - 1)
                        else item
                    }
                },
                onCloseClick = { },
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