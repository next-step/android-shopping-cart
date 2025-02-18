package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.cart.component.CartContents
import org.junit.Rule
import org.junit.Test

class CartContentsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `주어진_Cart의_총가격이_올바르게_나와야_한다`() {
        //given
        val cart = Cart(
            Product(2, "상품2", 12000, ""),
            5
        )

        //when
        composeTestRule.setContent {
            CartContents(cart)
        }

        //then
        composeTestRule
            .onNodeWithText("${cart.totalPrice.getFormattedPrice()}원")
            .assertIsDisplayed()
    }
}