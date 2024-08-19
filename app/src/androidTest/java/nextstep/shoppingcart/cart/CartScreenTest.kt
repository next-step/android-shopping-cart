package nextstep.shoppingcart.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.ui.cart.ShoppingCart
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
    }

    @Test
    fun 상품을_담으면_장바구니에_노출된다() {
        // when
        composeTestRule.setContent {
            Cart.addOne(
                product = Product(
                    productId = 1,
                    imageUrl = "https://picsum.photos/156/158",
                    name = "상품1",
                    price = 1200000000
                )
            )
            ShoppingCart(navController = rememberNavController(),
                cartItems = Cart.items
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("상품2")
            .assertIsNotDisplayed()
    }

    @Composable
    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // when
        val product = Product(
            productId = 1,
            imageUrl = "https://picsum.photos/156/158",
            name = "상품1",
            price = 12000
        )
        composeTestRule.setContent {
            Cart.addOne(
                product = product
            )
            ShoppingCart(navController = rememberNavController(),
                cartItems = Cart.items
            )
        }

        composeTestRule
            .onNodeWithText("상품1")
            .assertIsDisplayed()

        Cart.removeOne(product)

        // then
        composeTestRule
            .onNodeWithText("상품1")
            .assertIsNotDisplayed()
    }

    @Test
    fun 담긴_상품_가격의_총합이_다른_금액은_노출이_안된다() {
        // when
        composeTestRule.setContent {
            Cart.addOne(
                product = Product(
                    productId = 1,
                    imageUrl = "https://picsum.photos/156/158",
                    name = "상품1",
                    price = 12000
                )
            )
            ShoppingCart(navController = rememberNavController(),
                cartItems = Cart.items
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(13,000원)")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
// when
        composeTestRule.setContent {
            Cart.addOne(
                product = Product(
                    productId = 1,
                    imageUrl = "https://picsum.photos/156/158",
                    name = "상품1",
                    price = 12000
                )
            )
            ShoppingCart(navController = rememberNavController(),
                cartItems = Cart.items
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(13,000원)")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {

    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {

    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {

    }
}