package nextstep.shoppingcart.productList

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ProductListTopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun ProductListTopAppBar의_title이_상품_목록_이어야_한다() {
        // given
        composeTestRule.setContent {
            ProductListTopAppBar(
                count = 0,
                onCartButtonClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertExists()
    }

    @Test
    fun ProductListTopAppBar의_count인자가_0이면_뱃지가_0개여야_한다() {
        // given
        composeTestRule.setContent {
            ProductListTopAppBar(
                count = 0,
                onCartButtonClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("cart_badge")
            .isNotDisplayed()
    }

    @Test
    fun ProductListTopAppBar의_count인자가_3이면_뱃지가_3개여야_한다() {
        // given
        composeTestRule.setContent {
            ProductListTopAppBar(
                count = 3,
                onCartButtonClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("cart_badge")
            .isDisplayed()

        // then
        composeTestRule
            .onNodeWithText("3")
            .assertExists()
    }
}