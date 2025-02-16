package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.navigation.RouteType
import nextstep.shoppingcart.ui.list.ProductListScreen
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ProductListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_show_correct_top_bar_title_when_init_screen() {

        //when
        composeTestRule.setContent {
            ProductListScreen()
        }

        //then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_correct_cart_icon_when_init_screen() {

        //when
        composeTestRule.setContent {
            ProductListScreen()
        }

        //then
        composeTestRule
            .onNode(hasContentDescription("shopping_cart_icon"))
            .assertIsDisplayed()
    }

    @Test
    fun should_show_correct_product_item_when_product_list_provided() {
        //given
        val products = listOf(
            Product(
                id = 1,
                name = "테스트 상품1",
                price = 10000,
                imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
            ),
            Product(
                id = 2,
                name = "테스트 상품2",
                price = 20000,
                imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20240316_157%2F1710560166560p5Hns_JPEG%2F111696001378223548_958485840.jpg&type=a340"
            ),
        )

        //when
        composeTestRule.setContent {
            ProductListScreen(productList = products)
        }

        //then
        composeTestRule.onNodeWithText("테스트 상품1").assertExists()
        composeTestRule.onNodeWithText("테스트 상품2").assertExists()
    }

    @Test
    fun should_to_detail_route_type_when_click_product_item() {
        //given
        val products = listOf(
            Product(
                id = 1,
                name = "테스트 상품",
                price = 10000,
                imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
            ),
        )
        var routeType: RouteType? = null
        composeTestRule.setContent {
            ProductListScreen(productList = products, onRoute = { routeType = it })
        }

        //when
        composeTestRule.onNodeWithText("테스트 상품").performClick()


        //then
        assertEquals(routeType, RouteType.ToDetail(products[0]))
    }

    @Test
    fun should_to_cart_route_type_when_click_cart_icon() {
        //given
        var routeType: RouteType? = null
        composeTestRule.setContent {
            ProductListScreen(onRoute = { routeType = it })
        }

        //when
        composeTestRule.onNode(hasContentDescription("shopping_cart_icon")).performClick()

        //then
        assertEquals(routeType, RouteType.ToCart)
    }
}