package nextstep.shoppingcart

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import nextstep.shoppingcart.ui.cart.CartActivity
import nextstep.shoppingcart.ui.detail.ProductDetailActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RouteActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }

    @Test
    fun should_not_show_product_list_top_bar_title_when_click_product_item() {

        //when
        composeTestRule.onNodeWithText("PET-보틀-정사각형정사각형정사각형정사각형1").performClick()

        //then
        composeTestRule.onNodeWithText("상품 목록").assertDoesNotExist()
    }

    @Test
    fun should_show_product_detail_screen_when_click_product_item() {

        //when
        composeTestRule.onNodeWithText("PET-보틀-정사각형정사각형정사각형정사각형1").performClick()

        //then
        intended(hasComponent(ProductDetailActivity::class.java.name))
    }

    @Test
    fun should_not_show_cart_icon_when_click_cart_icon() {

        //when
        composeTestRule.onNode(hasContentDescription("shopping_cart_icon")).performClick()

        //then
        composeTestRule.onNodeWithText("상품 목록").assertDoesNotExist()
    }

    @Test
    fun should_show_cart_screen_when_click_shopping_cart_icon() {

        //when
        composeTestRule.onNode(hasContentDescription("shopping_cart_icon")).performClick()

        //then
        intended(hasComponent(CartActivity::class.java.name))
    }
}