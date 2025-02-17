package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.cart.component.CartAmount
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CartAmountTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `초기화면에_수량을_추가하는_아이콘이_있어야_한다`() {
        //given
        val cart = Cart(
            Product(1, "상품1", 1000, ""),
            4
        )
        //when
        composeTestRule.setContent {
            CartAmount(cart)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_add_icon")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `초기화면에_수량을_감소하는_아이콘이_있어야_한다`() {
        //given
        val cart = Cart(
            Product(3, "상품6", 1000, ""),
            6
        )
        //when
        composeTestRule.setContent {
            CartAmount(cart)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_remove_icon")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `주어진_아이템의_수량이_올바르게_나와야_한다`() {
        //given
        val cart = Cart(
            Product(2, "상품2", 1200, ""),
            5
        )
        //when
        composeTestRule.setContent {
            CartAmount(cart)
        }

        //then
        composeTestRule
            .onNodeWithText("5")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `수량을_추가하는_아이콘을_클릭시_추가이벤트가_전달되어야_한다`() {
        //given
        val cart = Cart(
            Product(3, "상품1", 1200, ""),
            6
        )
        var isSendAddEvent = false
        composeTestRule.setContent {
            CartAmount(cart, onAdd = { isSendAddEvent = true })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_add_icon")
            .performClick()


        //then
        assertTrue(isSendAddEvent)
    }

    @Test
    fun `수량을_감소하는_아이콘을_클릭시_추가이벤트가_전달되어야_한다`() {
        //given
        val cart = Cart(
            Product(7, "상품7", 1200, ""),
            1
        )
        var isSendRemoveEvent = false
        composeTestRule.setContent {
            CartAmount(cart, onRemove = { isSendRemoveEvent = true })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_remove_icon")
            .performClick()


        //then
        assertTrue(isSendRemoveEvent)
    }
}