package nextstep.shoppingcart.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product1 = Product(
        name = "상품1",
        price = 10000,
        imageUrl = ""
    )

    private val product2 = Product(
        name = "상품2",
        price = 5000,
        imageUrl = ""
    )

    @Before
    fun setUp() {
        Cart.removeAll(product1)
        Cart.removeAll(product2)
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        Cart.addOne(product1)
        Cart.addOne(product2)

        composeTestRule.setContent {
            CartScreen(
                cartItems = Cart.items,
                totalPrice = Cart.totalPrice,
                onBackButtonClick = {},
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(15,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given
        Cart.addOne(product1)

        composeTestRule.setContent {
            ShoppingCartTheme {
                var cartItems by remember { mutableStateOf(Cart.items) }

                CartScreen(
                    cartItems = cartItems,
                    totalPrice = Cart.totalPrice,
                    onBackButtonClick = {

                    },
                    onDeleteButtonClick = {
                        Cart.removeAll(it.product)
                        cartItems = Cart.items
                    },
                    onMinusButtonClick = {
                        Cart.removeOne(it.product)
                        cartItems = Cart.items
                    },
                    onPlusButtonClick = {
                        Cart.addOne(it.product)
                        cartItems = Cart.items
                    },
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("상품1")
            .assertExists()

        composeTestRule
            .onNodeWithTag("delete_button")
            .performClick()

        composeTestRule
            .onNodeWithText("상품1")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        Cart.addOne(product1)

        composeTestRule.setContent {
            ShoppingCartTheme {
                var cartItems by remember { mutableStateOf(Cart.items) }

                CartScreen(
                    cartItems = cartItems,
                    totalPrice = Cart.totalPrice,
                    onBackButtonClick = {

                    },
                    onDeleteButtonClick = {
                        Cart.removeAll(it.product)
                        cartItems = Cart.items
                    },
                    onMinusButtonClick = {
                        Cart.removeOne(it.product)
                        cartItems = Cart.items
                    },
                    onPlusButtonClick = {
                        Cart.addOne(it.product)
                        cartItems = Cart.items
                    },
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()

        composeTestRule
            .onNodeWithTag("plus_button")
            .performClick()

        composeTestRule
            .onNodeWithText("20,000원")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        Cart.addOne(product1)
        Cart.addOne(product1)

        composeTestRule.setContent {
            ShoppingCartTheme {
                var cartItems by remember { mutableStateOf(Cart.items) }

                CartScreen(
                    cartItems = cartItems,
                    totalPrice = Cart.totalPrice,
                    onBackButtonClick = {

                    },
                    onDeleteButtonClick = {
                        Cart.removeAll(it.product)
                        cartItems = Cart.items
                    },
                    onMinusButtonClick = {
                        Cart.removeOne(it.product)
                        cartItems = Cart.items
                    },
                    onPlusButtonClick = {
                        Cart.addOne(it.product)
                        cartItems = Cart.items
                    },
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("20,000원")
            .assertExists()

        composeTestRule
            .onNodeWithTag("minus_button")
            .performClick()

        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        Cart.addOne(product1)

        composeTestRule.setContent {
            ShoppingCartTheme {
                var cartItems by remember { mutableStateOf(Cart.items) }

                CartScreen(
                    cartItems = cartItems,
                    totalPrice = Cart.totalPrice,
                    onBackButtonClick = {

                    },
                    onDeleteButtonClick = {
                        Cart.removeAll(it.product)
                        cartItems = Cart.items
                    },
                    onMinusButtonClick = {
                        Cart.removeOne(it.product)
                        cartItems = Cart.items
                    },
                    onPlusButtonClick = {
                        Cart.addOne(it.product)
                        cartItems = Cart.items
                    },
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()

        composeTestRule
            .onNodeWithTag("minus_button")
            .performClick()

        composeTestRule
            .onNodeWithText("상품1")
            .assertDoesNotExist()
    }
}