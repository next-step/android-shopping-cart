package nextstep.shoppingcart.view.product.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var isBackClicked = false

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductDetailAppBar(onBack = { isBackClicked = true })
        }
    }

    @Test
    fun 상품_상세_타이틀이_표시된다() {
        composeTestRule.onNodeWithText(
            "상품 상세"
        ).assertExists()
    }

    @Test
    fun 뒤로가기_아이콘이_표시된다() {
        composeTestRule.onNodeWithContentDescription(
            "Detail Back"
        ).assertExists()
    }

    @Test
    fun 뒤로가기_아이콘을_클릭하면_직전_화면으로_이동한다() {
        composeTestRule.onNodeWithContentDescription(
            "Detail Back"
        ).performClick()

        assert(isBackClicked)
    }
}
