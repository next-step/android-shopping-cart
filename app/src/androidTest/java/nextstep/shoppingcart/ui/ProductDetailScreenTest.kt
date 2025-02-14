package nextstep.shoppingcart.ui

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.ProductModel
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = ProductModel(
        id = 4183L,
        imageUrl = "https://i.namu.wiki/i/DbNK9Ea0PuZvKG0kGoKLsmMPFOpHPkXNBnzehI6qxI66BVGkafNbgkTJZ9bhSrHbuAar4mxleD_VBa2wnUXSajuFalqw46l1xkjSkLpvtJHd2TQ13eUUP75OmqEGrB0uSdad0DWed5sTFXDYEGR5HQ.webp",
        name = "삼겹살",
        price = 12_000,
    )

    @Test
    fun 상품상세화면_이미지_상품명_금액_장바구니담기_버튼_노출() {
        // given
        composeTestRule.setContent {
            ProductDetailScreen(product)
        }

        // then
        composeTestRule
            .onNodeWithContentDescription("삽겹살 이미지")
            .isDisplayed()
        composeTestRule
            .onNodeWithText("삼겹살")
            .isDisplayed()
        composeTestRule
            .onNodeWithText("12,000원")
            .isDisplayed()
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .isDisplayed()
    }
}