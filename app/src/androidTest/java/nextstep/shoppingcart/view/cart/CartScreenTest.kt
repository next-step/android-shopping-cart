package nextstep.shoppingcart.view.cart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val dummyProducts = listOf(
        Product(name = "Product 1", price = 1_000, imageUrl = "https://example.com/image1.jpg"),
        Product(name = "Product 2", price = 2_000, imageUrl = "https://example.com/image2.jpg")
    )

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        Cart.clear()
        Cart.addOne(dummyProducts[0])
        Cart.addOne(dummyProducts[1])
        Cart.addOne(dummyProducts[1])

        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onBack = {},
                    onOrderClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithText("주문하기(5,000원)").assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        Cart.clear()
        Cart.addOne(dummyProducts[0])
        Cart.addOne(dummyProducts[1])
        Cart.addOne(dummyProducts[1])

        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onBack = {},
                    onOrderClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Product 1").assertExists()
        composeTestRule.onNodeWithContentDescription("Cart Delete Product 1").performClick()
        composeTestRule.onNodeWithText("Product 1").assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        Cart.clear()
        Cart.addOne(dummyProducts[0])
        Cart.addOne(dummyProducts[1])
        Cart.addOne(dummyProducts[1])

        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onBack = {},
                    onOrderClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Product 1").assertExists()
        composeTestRule.onNodeWithContentDescription("Cart Add Product 1").performClick()
        composeTestRule.onNodeWithText("주문하기(6,000원)").assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        Cart.clear()
        Cart.addOne(dummyProducts[0])
        Cart.addOne(dummyProducts[1])
        Cart.addOne(dummyProducts[1])

        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onBack = {},
                    onOrderClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Product 2").assertExists()
        composeTestRule.onNodeWithContentDescription("Cart Remove Product 2").performClick()
        composeTestRule.onNodeWithText("주문하기(3,000원)").assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        Cart.clear()
        Cart.addOne(dummyProducts[0])
        Cart.addOne(dummyProducts[1])
        Cart.addOne(dummyProducts[1])

        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = Cart.items,
                    onBack = {},
                    onOrderClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Product 1").assertExists()
        composeTestRule.onNodeWithContentDescription("Cart Remove Product 1").performClick()
        composeTestRule.onNodeWithText("Product 1").assertDoesNotExist()
    }
}
