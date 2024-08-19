package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import kotlinx.collections.immutable.persistentListOf
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
}
