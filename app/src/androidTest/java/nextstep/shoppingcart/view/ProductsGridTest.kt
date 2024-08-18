package nextstep.shoppingcart.view

import android.icu.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import nextstep.shoppingcart.model.Product
import org.junit.Before
import java.util.Locale

class ProductsGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    val products = listOf(
        Product(
            name = "Test Product 1",
            price = 1_000,
            imageUrl = "https://example.com/image1.jpg"
        ),
        Product(
            name = "Test Product 2",
            price = 2_000,
            imageUrl = "https://example.com/image2.jpg"
        )
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductsGrid(products = products)
        }
    }

    @Test
    fun 각_상품의_이미지와_텍스트가_표시된다() {
        products.forEach { product ->
            composeTestRule.onNodeWithContentDescription(product.name)
                .assertExists()
                .assertIsDisplayed()
            composeTestRule.onNodeWithText(product.name).assertExists()
            val formattedPrice = NumberFormat.getNumberInstance(Locale.KOREAN).format(product.price)
            composeTestRule.onNodeWithText("${formattedPrice}원").assertExists()
        }
    }
}