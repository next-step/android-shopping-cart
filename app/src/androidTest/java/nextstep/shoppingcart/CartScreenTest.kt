package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.list.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val items = mutableStateOf(emptyList<CartItem>())
    private val totalPrice = mutableStateOf(0)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CartScreen(
                cartItems = items.value,
                totalPrice = totalPrice.value,
                onClickItemRemove = {},
                onChangeItemCount = { _, _ -> },
                onBack = {},
            )
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        totalPrice.value = 50000

        // then
        composeTestRule.onNodeWithText("주문하기(50,000원)").assertExists()
    }

    @Test
    fun 상품_수량이_변경되면_해당_상품_가격도_반영된다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 1,
            )
        )

        // when
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 2,
            )
        )

        // then
        composeTestRule.onNodeWithText("2").assertExists()
        composeTestRule.onNodeWithText("20,000원").assertExists()
    }

    @Test
    fun 상품_목록이_비면_장바구니도_비워진다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 1,
            )
        )

        // when
        items.value = emptyList()

        // then
        composeTestRule.onNodeWithText("PET보틀 어쩌구").assertDoesNotExist()
    }
}
