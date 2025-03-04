package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.UUID

internal class StatelessCartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var cartItems by mutableStateOf(listOf<CartItem>())
    private var totalPrice by mutableStateOf(0)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = cartItems,
                    onBackPressed = {},
                    onButtonClick = {},
                    totalPrice = totalPrice,
                    onRemoveClick = {},
                    onPlusClick = {},
                    onMinusClick = {}
                )
            }
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // when
        totalPrice = 10000

        // then
        val formatedTotalPrice = String.format("%,d", totalPrice)
        composeTestRule
            .onNodeWithText("주문하기(${formatedTotalPrice}원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given
        cartItems = listOf(dummyCartItem)

        // when
        composeTestRule.onNodeWithTag("삭제").performClick()
        cartItems = cartItems - dummyCartItem

        // then
        composeTestRule.onNodeWithText(dummyCartItem.product.name).assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        val count = 1
        cartItems = listOf(dummyCartItem.copy(count = count))

        // when
        composeTestRule.onNodeWithTag("+").performClick()
        cartItems = listOf(dummyCartItem.copy(count = count + 1))

        // then
        val productPrice = dummyCartItem.product.price * (count + 1)
        composeTestRule.onNodeWithTag("상품 가격").assert(hasText("${String.format("%,d", productPrice)}원"))
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        val count = 2
        cartItems = listOf(dummyCartItem.copy(count = count))

        // when
        composeTestRule.onNodeWithTag("-").performClick()
        cartItems = listOf(dummyCartItem.copy(count = count - 1))

        // then
        val productPrice = dummyCartItem.product.price * (count - 1)
        composeTestRule.onNodeWithTag("상품 가격").assert(hasText("${String.format("%,d", productPrice)}원"))
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        val count = 1
        cartItems = listOf(dummyCartItem.copy(count = count))

        // when
        composeTestRule.onNodeWithTag("-").performClick()
        cartItems = cartItems - dummyCartItem

        // then
        composeTestRule.onNodeWithText(dummyCartItem.product.name).assertDoesNotExist()
    }

    companion object {
        private val dummyCartItem = CartItem(
            product = Product(UUID.randomUUID().toString(),"", "매콤달콤 떡볶이!", 8500),
            count = 1
        )
    }
}