package nextstep.shoppingcart

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
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
        composeTestRule.onNodeWithText("test").assertExists()
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
        composeTestRule.onNodeWithText("12000").assertExists()
    }

    @Test
    fun should_show_correct_product_image_when_create_product_item_component() {
        //given
        val mockProduct = Product(
            id = 5,
            name = "test55",
            price = 12000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340",
        )

        //when
        composeTestRule.setContent {
            ProductItem(
                modifier = Modifier.testTag("productImage"),
                item = mockProduct
            )
        }

        //then
        composeTestRule
            .onNodeWithTag("productImage")
            .assertExists()
            .assertIsDisplayed()
    }
}