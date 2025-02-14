package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.ProductModel
import org.junit.Rule
import org.junit.Test

class ProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    val product = ProductModel(
        id = 6871,
        imageUrl = "http://www.bing.com/search?q=nominavi",
        name = "우유",
        price = 2_000
    )

    @Test
    fun 상품목록_아이템에_상품이미지_상품명_상품가가격_노출() {
        // given
        composeTestRule.setContent {
            Product(product)
        }

        // then
        composeTestRule
            .onNodeWithText("우유")
            .isDisplayed()
        composeTestRule
            .onNodeWithText("2,000원")
            .isDisplayed()
        composeTestRule
            .onNodeWithContentDescription("우유 이미지")
            .isDisplayed()
    }
}