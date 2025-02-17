package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.dummyCartProductList
import org.junit.Rule
import org.junit.Test

class CartProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val model = dummyCartProductList.first()

    @Test
    fun 장바구니목록_아이템에_상품명_삭제_버튼_이미지_가격_갯수_조절_노출() {
        // given
        composeTestRule.setContent {
            CartProduct(model, listUpdate = {})
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
            .onNodeWithText("1,000원")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription("담기")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("1")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("제거")
            .assertIsDisplayed()
    }
}