package nextstep.shoppingcart.view.cart

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartTopAppBarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CartTopAppBar()
        }
    }

    @Test
    fun 장바구니_타이틀이_표시된다() {
        composeTestRule.onNodeWithText(
            "장바구니"
        ).assertExists()
    }

    @Test
    fun 뒤로가기_아이콘이_표시된다() {
        composeTestRule.onNodeWithContentDescription(
            "Cart Back"
        ).assertExists()
    }

    @Test
    fun 뒤로가기_아이콘을_클릭하면_직전_화면으로_이동하여_장바구니_화면이_종료된다() {
        composeTestRule.onNodeWithContentDescription(
            "Cart Back"
        ).performClick()

        assert(composeTestRule.activity.isFinishing)
    }
}
