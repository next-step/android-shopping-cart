package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.productList.ProductListTopAppBar
import org.junit.Rule
import org.junit.Test

class ProductListTopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun ProductListTopAppBar의_title이_상품_목록_이어야_한다() {
        // given
        composeTestRule.setContent {
            ProductListTopAppBar()
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertExists()
    }
}