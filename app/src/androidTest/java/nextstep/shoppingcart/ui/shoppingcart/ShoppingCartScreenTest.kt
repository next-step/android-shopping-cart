package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

internal class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_가격_총합이_노출된다() {
        // given: .
        val cartItem = CartItem(
            Product(
                id = 1L,
                name = "[든든] 동원 스위트콘",
                price = 99_800L,
                imageUrl = "https://picsum.photos/200"
            ),
            count = 1
        )
        composeTestRule.setContent {
            ShoppingCartScreen(
                cartItems = listOf(cartItem),
                totalPrice = cartItem.product.price,
                onBackButtonClick = {},
                onAddProductClick = {},
                onRemoveProductClick = {},
                onRemoveAllProductClick = {}
            )
        }

        // when: UI에서 특정 텍스트(가격 정보)가 보이는지 확인
        composeTestRule.onNodeWithText("주문하기(99,800원)").assertExists()
    }
}