package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.filter
import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.repository.CartRepository
import nextstep.shoppingcart.ui.screen.ShoppingCartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        CartRepository.clear()

        CartRepository.apply {
            addOne(Product(
                imageUrl = "https://example.com",
                title = PRODUCT_ONE,
                price = 1000,
            ))
            addOne(Product(
                imageUrl = "https://example.com",
                title = PRODUCT_TWO,
                price = 2000,
            ))
        }

        composeTestRule.setContent {
            var cartItemList by remember { mutableStateOf<List<CartItem>>(emptyList()) }
            cartItemList = CartRepository.items

            ShoppingCartScreen(
                cartItemList = cartItemList,
                onMinusCartItemClick = { cartItem ->
                    CartRepository.removeOne(cartItem.product)
                    cartItemList = CartRepository.items
                },
                onPlusCartItemClick = { cartItem ->
                    CartRepository.addOne(cartItem.product)
                    cartItemList = CartRepository.items
                },
                onCartItemDeleteClick = { cartItem ->
                    CartRepository.removeAll(cartItem.product)
                    cartItemList = CartRepository.items
                },
            )
        }
    }

    @Test
    fun 담긴_상품이_화면에_노출된다() {

        // 상품1, 상품2가 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertExists()

        composeTestRule.onNodeWithText(PRODUCT_TWO)
            .assertExists()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // 총합 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(3,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // 상품1 제거 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(REMOVE_BUTTON_DESCRIPTION)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1이 화면에 존재하지 않는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // 상품1 수량 증가 버튼 클릭
        composeTestRule.onAllNodesWithText(ADD_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1의 총 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assert(hasAnySibling(hasText("2,000원")))

        // 총합 가격이 정확한지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(4,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // 상품1 수량 추가
        repeat(2) {
            CartRepository.addOne(Product(
                imageUrl = "https://example.com",
                title = PRODUCT_ONE,
                price = 1000,
            ))
        }

        // 상품1 수량 감소 버튼 클릭
        composeTestRule.onAllNodesWithText(MINUS_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1의 총 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assert(hasAnySibling(hasText("2,000원")))

        // 총합 가격이 정확한지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(4,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // 상품1 수량 감소 버튼 클릭
        composeTestRule.onAllNodesWithText(MINUS_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1이 화면에 존재하지 않는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertDoesNotExist()
    }

    companion object {
        private const val PRODUCT_ONE = "상품1"
        private const val PRODUCT_TWO = "상품2"

        private const val ORDER_BUTTON_TITLE = "주문하기"
        private const val REMOVE_BUTTON_DESCRIPTION = "Remove Button"
        private const val ADD_BUTTON_TITLE = "+"
        private const val MINUS_BUTTON_TITLE = "-"
    }
}
