package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.R
import org.junit.Rule
import org.junit.Test

class ShoppingCartTopBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 탑바에_타이틀과_장바구니_아이콘_노출() {
        // given
        composeTestRule.setContent {
            ShoppingCartTopBar(
                titleResId = R.string.product_list,
                isCenter = true,
                showCartButton = true,
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .assertIsDisplayed()
    }

    @Test
    fun 탑바에_타이틀과_장바구니_아이콘_뒤로가기_버튼_노출() {
        // given
        composeTestRule.setContent {
            ShoppingCartTopBar(
                titleResId = R.string.product_list,
                isCenter = true,
                showCartButton = true,
                onClickBack = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .assertIsDisplayed()
    }
}