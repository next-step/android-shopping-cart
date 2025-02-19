package nextstep.shoppingcart.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.list.component.ProductImageContainer
import org.junit.Rule
import org.junit.Test

class ProductImageContainerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `아이템의_갯수가_0개일때_추가아이콘이_보여야_한다`() {

        //given
        val product = Product(
            id = 1,
            name = "test",
            price = 10000,
            imageUrl = "test",
        )
        val productCount = 0

        //when
        composeTestRule.setContent {
            ProductImageContainer(item = product, count = productCount)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${product.id}_add")
            .assertIsDisplayed()

    }

    @Test
    fun `아이템의_갯수가_1개이상일때_수량이_올바르게_보여야_한다`() {

        //given
        val product = Product(
            id = 3,
            name = "test",
            price = 10000,
            imageUrl = "test",
        )
        val productCount = 3

        //when
        composeTestRule.setContent {
            ProductImageContainer(item = product, count = productCount)
        }

        //then
        composeTestRule
            .onNodeWithText("3")
            .assertIsDisplayed()
    }

    @Test
    fun `아이템의_갯수가_1개이상일때_수량을_추가하는_아이콘이_보여야_한다`() {

        //given
        val product = Product(
            id = 2,
            name = "test",
            price = 10000,
            imageUrl = "test",
        )
        val productCount = 2

        //when
        composeTestRule.setContent {
            ProductImageContainer(item = product, count = productCount)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${product.id}_add_icon")
            .assertIsDisplayed()
    }

    @Test
    fun `아이템의_갯수가_1개이상일때_수량을_제거하는_아이콘이_보여야_한다`() {

        //given
        val product = Product(
            id = 6,
            name = "test1",
            price = 12000,
            imageUrl = "test2",
        )
        val productCount = 6

        //when
        composeTestRule.setContent {
            ProductImageContainer(item = product, count = productCount)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${product.id}_remove_icon")
            .assertIsDisplayed()
    }

    @Test
    fun `아이템의_갯수가_1개에서_수량을_제거_하였을때_추가아이콘이_보여야_한다`() {

        //given
        val product = Product(
            id = 2,
            name = "test4",
            price = 10000,
            imageUrl = "test6",
        )

        var productCountState by mutableIntStateOf(1)

        composeTestRule.setContent {
            ProductImageContainer(item = product, count = productCountState, onRemove = {
                productCountState--
            })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${product.id}_remove_icon")
            .performClick()

        //then
        composeTestRule
            .onNodeWithContentDescription("${product.id}_add")
            .assertIsDisplayed()
    }
}