package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class PriceTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 가격에_세자리마디_콤마_마지막에_원_노출() {
        // given
        val price = 20_000
        composeTestRule.setContent {
            PriceText(price = price)
        }

        // then
        composeTestRule
            .onNodeWithText("20,000원")
            .assertIsDisplayed()
    }
}