package nextstep.shoppingcart.view.product.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.Before

class ProductDetailButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var isButtonClicked = false

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductDetailButton(onButtonClick = { isButtonClicked = true })
        }
    }

    @Test
    fun 버튼_텍스트가_표시된다() {
        composeTestRule.onNodeWithText(
            "장바구니 담기"
        ).assertExists()
    }

    @Test
    fun 버튼을_클릭하면_장바구니_화면으로_이동한다() {
        composeTestRule.onNodeWithText(
            "장바구니 담기"
        ).performClick()

        assertTrue(isButtonClicked)
    }
}
