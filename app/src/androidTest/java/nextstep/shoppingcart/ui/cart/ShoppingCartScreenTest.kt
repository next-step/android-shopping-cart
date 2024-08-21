package nextstep.shoppingcart.ui.cart

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.common.component.CART_ITEM_COUNTER_DECREASE_TEST_TAG
import nextstep.shoppingcart.ui.common.component.CART_ITEM_COUNTER_INCREASE_TEST_TAG
import nextstep.shoppingcart.ui.cart.component.CART_LIST_ITEM_CLOSE_TEST_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        Cart.clear()
    }

    @Test
    fun 상품을_담으면_장바구니_목록에_표시되어야_한다() {
        // given
        val product =  Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)

        composeTestRule.setContent {
            ShoppingCartScreen(onBack = {})
        }

        // when

        // then
        composeTestRule
            .onNodeWithText("iPhone 15 Pro Max")
            .assertExists()
        composeTestRule
            .onNodeWithText("1")
            .assertExists()
    }

    @Test
    fun 상품을_담으면_총_가격이_표시되어야_한다() {
        // given
        val product =  Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        Cart.addOne(product)

        composeTestRule.setContent {
            ShoppingCartScreen(onBack = {})
        }

        // when

        // then
        composeTestRule
            .onNodeWithTag(SHOPPING_CART_ORDER_TEST_TAG)
            .assert(hasText("주문하기(3,800,000원)"))
    }

    @Test
    fun 수량을_증가할_수_있다() {
        // given
        val product =  Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        composeTestRule.setContent {
            ShoppingCartScreen(onBack = {})
        }

        // when
        composeTestRule
            .onNodeWithTag(CART_ITEM_COUNTER_INCREASE_TEST_TAG)
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(SHOPPING_CART_ORDER_TEST_TAG)
            .assert(hasText("주문하기(3,800,000원)"))
    }

    @Test
    fun 수량을_감소할_수_있다() {
        // given
        val product =  Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        Cart.addOne(product)
        composeTestRule.setContent {
            ShoppingCartScreen(onBack = {})
        }

        // when
        composeTestRule
            .onNodeWithTag(CART_ITEM_COUNTER_DECREASE_TEST_TAG)
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(SHOPPING_CART_ORDER_TEST_TAG)
            .assert(hasText("주문하기(1,900,000원)"))
    }

    @Test
    fun 상품_닫기_버튼을_누르면_상품목록에서_사라진다() {
        // given
        val product =  Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        composeTestRule.setContent {
            ShoppingCartScreen(onBack = {})
        }

        // when
        composeTestRule
            .onNodeWithTag(CART_LIST_ITEM_CLOSE_TEST_TAG)
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(SHOPPING_CART_ORDER_TEST_TAG)
            .assert(hasText("주문하기(0원)"))
    }

}
