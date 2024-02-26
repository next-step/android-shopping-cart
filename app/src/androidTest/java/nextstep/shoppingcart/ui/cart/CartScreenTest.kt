package nextstep.shoppingcart.ui.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.productsTestData
import nextstep.shoppingcart.domain.model.Cart
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 뒤로가기_버튼을_클릭할_수_있다() {
        // given
        var clicked = false
        composeTestRule.setContent {
            CartScreen(
                cart = Cart(items = emptyList()),
                onBackClick = { clicked = true },
                onCartDeleteClick = {},
                onCartPlusClick = {},
                onCartMinusClick = {},
                onOrderClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        assert(clicked)
    }

    @Test
    fun 장바구니의_상품_갯수를_증가시키면_상품_수량이_증가한다() {
        // given
        composeTestRule.setContent {
            var count by remember { mutableStateOf(0) }
            CartScreen(
                cart = Cart(
                    items = listOf(
                        Cart.Item(productsTestData[0], count)
                    )
                ),
                onBackClick = {},
                onCartDeleteClick = {},
                onCartPlusClick = { count++ },
                onCartMinusClick = {},
                onOrderClick = {},
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")
            .onFirst()
            .apply {
                performClick()
                performClick()
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량")
            .onFirst()
            .assertTextEquals("2")
    }

    @Test
    fun 장바구니의_상품_갯수를_감소시키면_상품_수량이_감소한다() {
        // given
        composeTestRule.setContent {
            var count by remember { mutableStateOf(5) }
            CartScreen(
                cart = Cart(
                    items = listOf(
                        Cart.Item(productsTestData[0], count)
                    )
                ),
                onBackClick = {},
                onCartDeleteClick = {},
                onCartPlusClick = {},
                onCartMinusClick = { count-- },
                onOrderClick = {},
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량감소")
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량")
            .onFirst()
            .assertTextEquals("4")
    }

    @Test
    fun 장바구니의_상품_갯수를_증가시키면_상품의_가격이_갯수만큼_증가한다() {
        // given
        composeTestRule.setContent {
            var count by remember { mutableStateOf(0) }
            CartScreen(
                cart = Cart(
                    items = listOf(
                        Cart.Item(productsTestData[0].copy(price = 10000), count)
                    )
                ),
                onBackClick = {},
                onCartDeleteClick = {},
                onCartPlusClick = { count++ },
                onCartMinusClick = {},
                onOrderClick = {},
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")
            .onFirst()
            .apply {
                performClick()
                performClick()
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템가격")
            .onFirst()
            .assertTextEquals("20,000원")
    }

    @Test
    fun 모든상품의_갯수만큼_전체_상품가격이_결정된다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                cart = Cart(
                    items = listOf(
                        Cart.Item(productsTestData[0].copy(price = 10000), 2),
                        Cart.Item(productsTestData[1].copy(price = 5000), 1),
                    )
                ),
                onBackClick = {},
                onCartDeleteClick = {},
                onCartPlusClick = {},
                onCartMinusClick = {},
                onOrderClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(25,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니에서_상품을_제거할_수_있다() {
        // given
        var deleteCalled = false
        composeTestRule.setContent {
            CartScreen(
                cart = Cart(
                    items = listOf(
                        Cart.Item(productsTestData[0], 1),
                    )
                ),
                onBackClick = {},
                onCartDeleteClick = {
                    assert(it.product.id == productsTestData[0].id)
                    deleteCalled = true
                },
                onCartPlusClick = {},
                onCartMinusClick = {},
                onOrderClick = {},
            )
        }

        // when
        composeTestRule
            .onAllNodesWithContentDescription("장바구니::아이템제거")
            .onFirst()
            .performClick()

        // then
        assert(deleteCalled)
    }
}
