package nextstep.shoppingcart.view.cart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartTopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var isBackClicked = false

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CartTopAppBar(onBack = { isBackClicked = true })
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
    fun 뒤로가기_아이콘을_클릭하면_콜백이_호출된다() {
        composeTestRule.onNodeWithContentDescription(
            "Cart Back"
        ).performClick()

        assertTrue(isBackClicked)
    }
}
