package nextstep.shoppingcart.cart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class CartTopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun TopAppBar의_title이_장바구니_이어야_한다() {
        // given
        composeTestRule.setContent {
            CartTopAppBar()
        }

        // then
        composeTestRule
            .onNodeWithText("장바구니")
            .assertExists()
    }
}