package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.features.productlist.components.ProductListItem
import org.junit.Rule
import org.junit.Test

class ProductListItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품이_장바구니에_담겨있지_않다면_상품추가_버튼이_표시된다() {
        // given
        composeTestRule.setContent {
            ProductListItem(
                product = FakeProductRepository.getFirstProduct(),
                count = null,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onProductClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithContentDescription("추가")
            .assertIsDisplayed()
    }

    @Test
    fun 상품이_장바구니에_1개_이상_담긴다면_수량조절_버튼이_표시된다() {
        // given
        composeTestRule.setContent {
            ProductListItem(
                product = FakeProductRepository.getFirstProduct(),
                count = 1,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onProductClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("+")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("−")
            .assertIsDisplayed()
    }
}
