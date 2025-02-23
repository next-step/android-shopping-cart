package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

internal class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_가격_총합이_노출된다() {
        // given 가격 총합이 99,800원 일 때
        val cartItems = listOf(
            CartItem(
                Product(
                    id = 1L,
                    name = "[든든] 동원 스위트콘",
                    price = 50_000L,
                    imageUrl = "https://picsum.photos/200"
                ),
                count = 1
            ),
            CartItem(
                Product(
                    id = 2L,
                    name = "[든든] 동원 스위트콘",
                    price = 49_800L,
                    imageUrl = "https://picsum.photos/200"
                ),
                count = 1
            )
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItems = cartItems,
                totalPrice = 99_800,
                onBackButtonClick = {},
                onAddProductClick = {},
                onRemoveProductClick = {},
                onRemoveAllProductClick = {}
            )
        }

        // when: UI에서 특정 텍스트(가격 정보)가 보이는지 확인
        composeTestRule.onNodeWithText("주문하기(99,800원)").assertExists()
    }

    @Test
    fun 장바구니에서_상품_제거하기를_클릭하면_상품이_전부_제거된다() {
        val item = Product(
            id = 1L,
            name = "[든든] 동원 스위트콘",
            price = 10_000L,
            imageUrl = "https://picsum.photos/200"
        )
        val cartItems = mutableListOf(CartItem(product = item, count = 3))
        val onRemoveAllProductClick: (Product) -> Unit = { product ->
            cartItems.removeIf { it.product == product }
        }

        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItems = cartItems,
                totalPrice = 30_000,
                onBackButtonClick = {},
                onAddProductClick = {},
                onRemoveProductClick = {},
                onRemoveAllProductClick = onRemoveAllProductClick,
            )
        }

        composeTestRule.onNodeWithContentDescription("장바구니에서 상품 제거하기").performClick()
        assert(cartItems.find { it.product == item } == null)
    }
}