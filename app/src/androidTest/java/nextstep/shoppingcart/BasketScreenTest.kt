package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onSiblings
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.basket.BasketScreen
import nextstep.shoppingcart.ui.basket.BasketState
import nextstep.shoppingcart.ui.model.CartItem
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.UUID

internal class BasketScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                var state by remember {
                    mutableStateOf(
                        BasketState(
                            isInitialLoading = false,
                            isLoadingShow = false,
                            cartItems = defaultItems,
                        )
                    )
                }

                BasketScreen(
                    state = state,
                    navigateBack = {},
                    onRemoveCartItemClick = { removeItem ->
                        state = state.copy(
                            cartItems = state.cartItems.filterNot { item ->
                                item == removeItem
                            }
                        )
                    },
                    onIncreaseQuantityClick = {},
                    onDecreaseQuantityClick = {},
                )
            }
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        composeTestRule
            .onNodeWithTag("orderButton")
            .assertTextEquals("주문하기(10,000원)")
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // 맨 처음 상품을 제거한다.
        composeTestRule
            .onNodeWithContentDescription("Item 0 장바구니 아이템을 삭제합니다.")
            .performClick()

        composeTestRule
            .onNodeWithText("Item 0")
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
