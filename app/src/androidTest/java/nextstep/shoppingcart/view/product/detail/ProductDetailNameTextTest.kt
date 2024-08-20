package nextstep.shoppingcart.view.product.detail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ProductDetailNameTextTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품명이_표시된다() {
        val productName = "[최고심] 빅허그인형"

        composeTestRule.setContent {
            ProductDetailNameText(productName = productName)
        }

        composeTestRule.onNodeWithText(productName).assertExists()
    }
}
