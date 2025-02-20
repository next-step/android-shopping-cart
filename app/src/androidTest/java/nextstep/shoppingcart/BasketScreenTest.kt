package nextstep.shoppingcart

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import nextstep.shoppingcart.ui.basket.BasketScreen
import nextstep.shoppingcart.ui.basket.BasketState
import nextstep.shoppingcart.ui.model.CartItem
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import org.junit.Rule
import org.junit.Test
import java.util.UUID

internal class BasketScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                BasketScreen(
                    state = BasketState(
                        isInitialLoading = false,
                        isLoadingShow = false,
                        cartItems = defaultItems,
                    ),
                    navigateBack = {},
                    onRemoveCartItemClick = {},
                    onIncreaseQuantityClick = {},
                    onDecreaseQuantityClick = {},
                )
            }
        }
        composeTestRule
            .onNodeWithTag("orderButton")
            .assertTextEquals("주문하기(10,000원)")
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {

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

    companion object {
        private val defaultItems = List(100) {
            CartItem(
                product = Product(
                    id = UUID.randomUUID().toString(),
                    imageUrl = "",
                    name = "Item $it",
                    price = 100,
                ),
                count = 1,
            )
        }
    }
}
