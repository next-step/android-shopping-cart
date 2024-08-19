package nextstep.shoppingcart.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.product.ProductsGrid
import org.junit.Before

class ProductsGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val products = listOf(
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
        composeTestRule.onNodeWithContentDescription(products[0].name)
            .assertExists()
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(products[0].name).assertExists()
        composeTestRule.onNodeWithText("1,000원").assertExists()

        composeTestRule.onNodeWithContentDescription(products[1].name)
            .assertExists()
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(products[1].name).assertExists()
        composeTestRule.onNodeWithText("2,000원").assertExists()

    }
}
