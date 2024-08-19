package nextstep.shoppingcart.view.product.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ProductDetailPriceTextTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 금액이_표시된다() {
        val productPrice = 43_000
        val priceText = "43,000원"

        composeTestRule.setContent {
            ProductDetailPriceText(productPrice = productPrice)
        }

        composeTestRule.onNodeWithText(priceText).assertExists()
    }
}
