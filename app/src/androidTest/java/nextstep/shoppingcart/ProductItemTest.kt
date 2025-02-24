package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productList.ProductItem
import org.junit.Rule
import org.junit.Test

class ProductItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun product의_name이_상품일_때_상품_텍스트가_노출되어야_한다() {
        // given
        val product = Product(
            name = "상품",
            price = 10000,
            imageUrl = ""
        )

        // when
        composeTestRule.setContent {
            ProductItem(product)
        }

        // then
        composeTestRule
            .onNodeWithText("상품")
            .assertExists()
    }

    @Test
    fun product의_price가_10000일_때_10_000원_텍스트가_노출되어야_한다() {
        // given
        val product = Product(
            name = "상품",
            price = 10000,
            imageUrl = ""
        )

        // when
        composeTestRule.setContent {
            ProductItem(product)
        }

        // then
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()
    }
}