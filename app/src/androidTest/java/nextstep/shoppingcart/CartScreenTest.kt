package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.Cart.items
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val cartItems = mutableStateListOf<CartItem>()
    var totalPrice by mutableIntStateOf(0)
        private set

    @Before
    fun setup() {
        composeTestRule.setContent {
            ShoppingCartScreen(
                products = cartItems,
                totalPrice = totalPrice,
                onItemAdd = {},
                onItemRemove = {},
                onDelete = {},
                onBackClick = {}
            )
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given: 1000원, 2000원, 3000원 상품이 장바구니에 추가되었을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 1))
        cartItems.add(CartItem(Product("", "상품2", 2000), 1))
        cartItems.add(CartItem(Product("", "상품3", 3000), 1))
        totalPrice = 6000

        // when
        composeTestRule.waitForIdle()
        // then
        composeTestRule.onNodeWithText("주문하기(6,000원)", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given: 가격이 1000원인 상품이 1개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 1))
        totalPrice = 1000
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 2개로 증가
        cartItems[0] = CartItem(cartItems[0].product, 2)
        totalPrice = 2000
        composeTestRule.waitForIdle()

        //then: 상품 가격 총합이 2000원이 되어야 한다.
        composeTestRule.onNodeWithText("2,000원", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given: 가격이 1000원인 상품이 3개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 3))
        totalPrice = 3000
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 2개로 감소
        cartItems[0] = CartItem(cartItems[0].product, 2)
        totalPrice = 2000
        composeTestRule.waitForIdle()

        //then: 상품 가격 총합이 2000원이 되어야 한다.
        composeTestRule.onNodeWithText("2,000원", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품을_제거하면_빈_화면이_노출된다() {
        // given: 가격이 1000원인 상품이 1개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 3))
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 감소
        cartItems.clear()
        composeTestRule.waitForIdle()

        // then: 상품1이 없어야 함
        composeTestRule
            .onNodeWithText("상품1")
            .assertDoesNotExist()
    }
}