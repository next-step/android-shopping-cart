package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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

    private fun updateTotalPrice() {
        totalPrice = cartItems.sumOf { it.totalPrice }
    }

    @Before
    fun setup() {
        composeTestRule.setContent {
            ShoppingCartScreen(
                products = cartItems,
                totalPrice = totalPrice,
                onItemAdd = { product ->
                    val item = cartItems.find { it.product == product }
                    if (item == null) {
                        cartItems.add(CartItem(product, 1))
                    } else {
                        val index = cartItems.indexOf(item)
                        cartItems[index] = item.copy(count = item.count + 1)
                    }
                    updateTotalPrice()
                },
                onItemRemove = {
                    cartItems.find { item -> item.product == it }?.let { cartItem ->
                        val index = cartItems.indexOf(cartItem)
                        if (cartItem.count > 1)
                            cartItems[index] = cartItem.copy(count = cartItem.count - 1)
                        else
                            cartItems.remove(cartItem)
                    }
                    updateTotalPrice()
                },
                onDelete = {
                    cartItems.removeIf { item -> item.product == it }
                    updateTotalPrice()
                },
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
        updateTotalPrice()
        // when
        composeTestRule.waitForIdle()
        // then
        composeTestRule.onNodeWithText("6,000원", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given: 1000원, 2000원, 3000원 상품이 장바구니에 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 1))
        cartItems.add(CartItem(Product("", "상품2", 2000), 1))
        cartItems.add(CartItem(Product("", "상품3", 3000), 1))
        composeTestRule.waitForIdle()

        // when: 상품2를 장바구니에서 제거
        composeTestRule.onAllNodesWithContentDescription("삭제")[1].performClick()
        composeTestRule.waitForIdle()

        // then: 상품2가 없어야 함
        composeTestRule
            .onNodeWithText("상품2")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given: 가격이 1000원인 상품이 1개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 1))
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 2개로 증가
        composeTestRule.onAllNodesWithContentDescription("추가")[0].performClick()
        composeTestRule.waitForIdle()

        //then: 상품 가격 총합이 2000원이 되어야 한다.
        composeTestRule.onNodeWithText("2,000원", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given: 가격이 1000원인 상품이 3개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 3))
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 2개로 증가
        composeTestRule.onAllNodesWithContentDescription("빼기")[0].performClick()
        composeTestRule.waitForIdle()

        //then: 상품 가격 총합이 2000원이 되어야 한다.
        composeTestRule.onNodeWithText("2,000원", substring = true).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given: 가격이 1000원인 상품이 1개 있을 때
        cartItems.add(CartItem(Product("", "상품1", 1000), 1))
        composeTestRule.waitForIdle()

        // when: 상품의 수량을 감소
        composeTestRule.onAllNodesWithContentDescription("빼기")[0].performClick()
        composeTestRule.waitForIdle()

        // then: 상품1이 없어야 함
        composeTestRule
            .onNodeWithText("상품1")
            .assertDoesNotExist()
    }
}