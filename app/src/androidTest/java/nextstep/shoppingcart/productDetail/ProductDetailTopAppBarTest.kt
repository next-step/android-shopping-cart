package nextstep.shoppingcart.productDetail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ProductDetailTopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun TopAppBar의_title이_상품_상세_이어야_한다() {
        // given
        composeTestRule.setContent {
            ProductDetailTopAppBar()
        }

        // then
        composeTestRule
            .onNodeWithText("상품 상세")
            .assertExists()
    }
}