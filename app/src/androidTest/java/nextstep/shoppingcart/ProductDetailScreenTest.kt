package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.detail.ProductDetailScreen
import nextstep.shoppingcart.util.CartUtil
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun should_show_correct_top_bar_title_when_init_screen() {
        //given
        val item = Product(
            id = 1,
            name = "테스트 상품",
            price = 10000,
            imageUrl = ""
        )

        //when
        composeTestRule.setContent {
            ProductDetailScreen(item = item)
        }

        //then
        composeTestRule
            .onNodeWithText("상품 상세")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_back_button_when_init_screen() {
        //given
        val item = Product(
            id = 1,
            name = "테스트 상품",
            price = 10000,
            imageUrl = ""
        )

        //when
        composeTestRule.setContent {
            ProductDetailScreen(item = item)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("back_icon")
            .assertIsDisplayed()
    }


    @Test
    fun should_show_correct_name_when_product_item_provided() {
        //given
        val item = Product(
            id = 2,
            name = "테스트 상품2",
            price = 12000,
            imageUrl = ""
        )

        //when
        composeTestRule.setContent {
            ProductDetailScreen(item = item)
        }

        //then
        composeTestRule
            .onNodeWithText("테스트 상품2")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_correct_price_when_product_item_provided() {
        //given
        val item = Product(
            id = 3,
            name = "테스트 상품3",
            price = 14000,
            imageUrl = ""
        )

        //when
        composeTestRule.setContent {
            ProductDetailScreen(item = item)
        }

        //then
        composeTestRule
            .onNodeWithText("금액")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("14,000원")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_correct_image_when_product_item_provided() {
        //given
        val item = Product(
            id = 10,
            name = "테스트 상품10",
            price = 16000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
        )

        //when
        composeTestRule.setContent {
            ProductDetailScreen(item = item)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("product_image")
            .assertIsDisplayed()
    }


    @Test
    fun should_occur_back_event_when_click_back_button() {
        //given
        var isOccurBackEvent = false

        val item = Product(
            id = 1,
            name = "테스트 상품",
            price = 10000,
            imageUrl = ""
        )
        composeTestRule.setContent {
            ProductDetailScreen(item = item, onBack = { isOccurBackEvent = true })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("back_icon")
            .performClick()

        //then
        assertTrue(isOccurBackEvent)
    }

    @Test
    fun should_cart_item_when_click_cart_button() {

        //given
        val item = Product(
            id = 1,
            name = "테스트 상품",
            price = 10000,
            imageUrl = ""
        )
        composeTestRule.setContent {
            ProductDetailScreen(item = item, onCart = { item -> CartUtil.addOne(item) })
        }

        //when
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .performClick()

        //then
        assertTrue(CartUtil.items.find { it.product.id == item.id } != null)
    }

}