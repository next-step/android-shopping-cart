package nextstep.shoppingcart.conponent

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.component.ProductPrice
import org.junit.Rule
import org.junit.Test

class ProductPriceTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun price기_0이면_0원이_노출되어야한다() {
        // when
        composeTestRule.setContent {
            ProductPrice(
                price = 0
            )
        }

        // then
        composeTestRule
            .onNodeWithText("0원")
            .assertExists()
    }

    @Test
    fun price기_1_000_000이면_1_000_000원이_노출되어야한다() {
        // when
        composeTestRule.setContent {
            ProductPrice(
                price = 1_000_000
            )
        }

        // then
        composeTestRule
            .onNodeWithText("1,000,000원")
            .assertExists()
    }
}