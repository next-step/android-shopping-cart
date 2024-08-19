package nextstep.shoppingcart.view.product

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test
import nextstep.shoppingcart.model.Product
import org.junit.Before

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductItem(
                product = Product(
                    name = "Test Product",
                    price = 1_000,
                    imageUrl = "https://example.com/image.jpg"
                ),
                onItemClick = { }
            )
        }
    }

    @Test
    fun 상품_이미지가_표시된다() {
        composeTestRule.onNodeWithContentDescription("Test Product")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun 상품명이_표시된다() {
        composeTestRule.onNodeWithText("Test Product").assertExists()
    }

    @Test
    fun 상품_가격이_표시된다() {
        composeTestRule.onNodeWithText("1,000원").assertExists()
    }
}
