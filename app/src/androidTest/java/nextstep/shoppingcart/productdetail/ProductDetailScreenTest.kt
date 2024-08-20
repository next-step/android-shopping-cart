package nextstep.shoppingcart.productdetail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.dummyProducts
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val cart = Cart

    @Before
    fun setup() {
        cart.clear()
    }

    @Test
    fun 장바구니에_추가_버튼을_누르면_장바구니에_담긴_장바구니_품목의_수량이_늘어납니다() {
        // given
        val cartSize = cart.items.size
        composeTestRule.setContent {
            ProductDetailScreen(
                product = dummyProducts.first(),
                onBackClick = {},
                onAddToCartClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .performClick()

        // then
        Assert.assertEquals(cartSize + 1, cart.items.size)
    }
}