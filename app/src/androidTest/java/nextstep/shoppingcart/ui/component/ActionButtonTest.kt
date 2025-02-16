package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ActionButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 버튼_노출() {
        // given
        val text = "장바구니 담기"
        composeTestRule.setContent {
            ActionButton(text = text, onClick = {})
        }

        // then
        composeTestRule
            .onNodeWithText(text)
            .assertIsDisplayed()
    }
}