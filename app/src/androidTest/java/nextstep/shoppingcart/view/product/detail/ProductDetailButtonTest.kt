package nextstep.shoppingcart.view.product.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test
import org.junit.Before

class ProductDetailButtonTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductDetailScreen(Product("name", "imageUrl", 0))
        }
    }

    @Test
    fun 버튼_텍스트가_표시된다() {
        composeTestRule.onNodeWithText(
            "장바구니 담기"
        ).assertExists()
    }

    @Test
    fun 버튼을_클릭하면_장바구니_화면으로_이동하여_상품_상세_화면이_보이지_않는다() {
        composeTestRule.onNodeWithText(
            "장바구니 담기"
        ).performClick()

        composeTestRule.onNodeWithText(
            "장바구니 담기"
        ).assertDoesNotExist()
    }
}
