package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import nextstep.shoppingcart.ui.screen.BaseComposeTest
import nextstep.shoppingcart.ui.screen.products.model.dummyProductModels
import org.junit.Test

class ShoppingCartScreenTest : BaseComposeTest() {

    @Test
    fun 장바구니_상품의_갯수가_증가하면_상품의_수량도_증가한다() {
        composeTestRule.setContent {
            var count by remember { mutableStateOf(0) }
            ShoppingCartScreen(
                carItems = persistentListOf(CartItem(count = count, product = dummyProductModels[0])),
                onClearClick = {},
                onMinusClick = {},
                onPlusClick = { count += 1 },
                onOrderClick = {},
                onNavigationClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("장바구니 수량 증가 버튼")
            .performClick()

        composeTestRule
            .onNodeWithTag("장바구니 담긴 수량")
            .assertTextEquals("1")
    }

    @Test
    fun 장바구니_상품의_갯수가_줄어들면_상품의_수량도_줄어든다() {
        composeTestRule.setContent {
            var count by remember { mutableStateOf(1) }
            ShoppingCartScreen(
                carItems = persistentListOf(CartItem(count = count, product = dummyProductModels[0])),
                onClearClick = {},
                onMinusClick = { count -= 1 },
                onPlusClick = { },
                onOrderClick = { },
                onNavigationClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("장바구니 수량 감소 버튼")
            .performClick()

        composeTestRule
            .onNodeWithTag("장바구니 담긴 수량")
            .assertTextEquals("0")
    }


    @Test
    fun 장바구니_상품의_갯수를_증가시키면_증가한만큼_총_구매금액도_증가한다() {
        val mockPrice = 10_000
        composeTestRule.setContent {
            var count by remember { mutableStateOf(0) }
            ShoppingCartScreen(
                carItems = persistentListOf(CartItem(count = count, product = dummyProductModels[0].copy(price = mockPrice))),
                onClearClick = { },
                onMinusClick = { },
                onPlusClick = { count += 1 },
                onOrderClick = { },
                onNavigationClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("장바구니 수량 증가 버튼")
            .performClick()
            .performClick()

        composeTestRule
            .onNodeWithTag("장바구니 주문 버튼")
            .assertTextEquals("주문하기(20,000원)")
    }

    @Test
    fun 장바구니_상품의_갯수를_감소시키면_감소한만큼_총_구매금액도_증가한다() {
        val mockPrice = 10_000
        composeTestRule.setContent {
            var count by remember { mutableStateOf(3) }
            ShoppingCartScreen(
                carItems = persistentListOf(CartItem(count = count, product = dummyProductModels[0].copy(price = mockPrice))),
                onClearClick = { },
                onMinusClick = { count -= 1 },
                onPlusClick = { },
                onOrderClick = { },
                onNavigationClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("장바구니 수량 감소 버튼")
            .performClick()
            .performClick()

        composeTestRule
            .onNodeWithTag("장바구니 주문 버튼")
            .assertTextEquals("주문하기(10,000원)")
    }

    @Test
    fun 장바구니_상품의_제거버튼을누르면_해당제품은_제거되어야한다() {
        val mockName = "test"
        val dummyProduct = dummyProductModels[0].copy(name = mockName)
        composeTestRule.setContent {
            var itemList by remember {
                mutableStateOf(listOf(CartItem(count = 2, product = dummyProduct)))
            }
            ShoppingCartScreen(
                carItems = itemList.toPersistentList(),
                onClearClick = { deletedProduct ->
                    assert(dummyProduct.id == deletedProduct.id)
                    itemList = itemList.filter { item -> item.product.id != dummyProduct.id }
                },
                onMinusClick = { },
                onPlusClick = { },
                onOrderClick = { },
                onNavigationClick = {},
            )
        }

        composeTestRule
            .onNodeWithContentDescription("$mockName 상품")
            .assertExists()

        composeTestRule
            .onNodeWithContentDescription("장바구니 제거 버튼")
            .performClick()

        composeTestRule
            .onNodeWithContentDescription("$mockName 상품")
            .assertDoesNotExist()
    }
}
