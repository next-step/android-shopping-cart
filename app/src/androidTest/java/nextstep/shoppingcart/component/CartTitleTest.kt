package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.cart.component.CartTitle
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CartTitleTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `초기화면에_아이템을_삭제하는_아이콘이_있어야_한다`() {
        //given
        val cart = Cart(
            Product(10, "상품10", 1200, ""),
            9
        )
        //when
        composeTestRule.setContent {
            CartTitle(cart.product)
        }

        //then
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_delete_icon")
            .assertIsDisplayed()

    }

    @Test
    fun `주어진_아이템의_이름이_올바르게_나와야_한다`() {
        //given
        val cart = Cart(
            Product(2, "상품2", 1200, ""),
            5
        )
        //when
        composeTestRule.setContent {
            CartTitle(cart.product)
        }

        //then
        composeTestRule
            .onNodeWithText("상품2")
            .assertIsDisplayed()
    }

    @Test
    fun `아이템을_삭제하는_아이콘을_클릭시_삭제이벤트가_전달되어야_한다`() {
        //given
        val cart = Cart(
            Product(3, "상품1", 1200, ""),
            6
        )
        var isSendDeleteEvent = false
        composeTestRule.setContent {
            CartTitle(cart.product, onDelete = { isSendDeleteEvent = true })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${cart.product.id}_delete_icon")
            .performClick()

        //then
        assertTrue(isSendDeleteEvent)
    }
}