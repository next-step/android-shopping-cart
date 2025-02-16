package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.cart.CartScreen
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun should_show_correct_top_bar_title_when_init_screen() {

        //when
        composeTestRule.setContent {
            CartScreen()
        }

        //then
        composeTestRule
            .onNodeWithText("장바구니")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_back_button_when_init_screen() {

        //when
        composeTestRule.setContent {
            CartScreen()
        }

        //then
        composeTestRule
            .onNode(hasContentDescription("back_icon"))
            .assertIsDisplayed()
    }

    @Test
    fun should_send_back_message_when_click_back_button() {
        //given
        var backMessage = ""


        composeTestRule.setContent {
            CartScreen(onBack = { backMessage = "back" })
        }

        //when
        composeTestRule.onNode(hasContentDescription("back_icon")).performClick()

        //then
        assert(backMessage == "back")
    }
}