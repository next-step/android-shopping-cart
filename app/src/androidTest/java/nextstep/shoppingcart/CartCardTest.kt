package nextstep.shoppingcart

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.ui.cart.component.CartCard
import org.junit.Rule
import org.junit.Test

class CartCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 전달받은_상품_이름을_노출한다() {
        // given : 상품을 받는다.
        val product = Product(
            id = 2,
            imgUrl = "https://picsum.photos/seed/2/200",
            name = "상품 2",
            price = 100
        )

        // when : 상품 카드를 노출한다.
        composeTestRule.setContent {
            CartCard(
                modifier = Modifier,
                cartItem = CartItem(product, 1),
                onMinusClick = {},
                onPlusClick = {},
                onRemoveClick = {}
            )
        }

        // then : 상품의 이름이 노출되어야한다.
        composeTestRule
            .onNodeWithText("상품 2")
            .assertExists()
    }

    @Test
    fun 전달받은_상품_가격을_노출한다() {
        // given : 상품을 받는다.
        val product = Product(
            id = 2,
            imgUrl = "https://picsum.photos/seed/2/200",
            name = "상품 2",
            price = 2000
        )

        // when : 상품 카드를 노출한다.
        composeTestRule.setContent {
            CartCard(
                modifier = Modifier,
                cartItem = CartItem(product, 1),
                onMinusClick = {},
                onPlusClick = {},
                onRemoveClick = {}
            )
        }

        // then : 상품의 가격이 노출되어야한다.
        composeTestRule
            .onNodeWithText("2,000원")
            .assertExists()
    }
}