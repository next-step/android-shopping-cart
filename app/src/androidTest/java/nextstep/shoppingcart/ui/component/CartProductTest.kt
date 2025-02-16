package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.CartProductModel
import nextstep.shoppingcart.model.ProductModel
import org.junit.Rule
import org.junit.Test

class CartProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = ProductModel(
        id = 6871,
        imageUrl = "http://www.bing.com/search?q=nominavi",
        name = "우유",
        price = 2_000
    )
    private val model = CartProductModel(
        product = product,
        count = 11,
    )

    @Test
    fun 장바구니목록_아이템에_상품명_삭제_버튼_이미지_가격_갯수_조절_노출() {
        // given
        composeTestRule.setContent {
            CartProduct(model)
        }

        // then
        composeTestRule
            .onNodeWithText(model.name)
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("삭제")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("우유 이미지")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("2,000원")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription("담기")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("11")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("제거")
            .assertIsDisplayed()
    }
}