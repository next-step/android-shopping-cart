package nextstep.shoppingcart.view.product.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailAppBarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductDetailAppBar()
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
    fun 뒤로가기_아이콘을_클릭하면_직전_화면으로_이동하여_상품_상세_화면이_종료된다() {
        composeTestRule.onNodeWithContentDescription(
            "Detail Back"
        ).performClick()

        assert(composeTestRule.activity.isFinishing)
    }
}
