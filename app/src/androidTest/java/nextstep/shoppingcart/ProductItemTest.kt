package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.list.component.ProductItem
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_show_correct_product_name_when_create_product_item_component() {
        //given
        val mockProduct = Product(
            id = 1,
            name = "test",
            price = 10000,
            imageUrl = "test",
        )

        //when
        composeTestRule.setContent {
            ProductItem(item = mockProduct)
        }

        //then
        composeTestRule
            .onNodeWithText("test")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_correct_product_price_when_create_product_item_component() {
        //given
        val mockProduct = Product(
            id = 4,
            name = "test4",
            price = 12000,
            imageUrl = "test4",
        )

        //when
        composeTestRule.setContent {
            ProductItem(item = mockProduct)
        }

        //then
        composeTestRule
            .onNodeWithText("12000")
            .assertIsDisplayed()
    }
}