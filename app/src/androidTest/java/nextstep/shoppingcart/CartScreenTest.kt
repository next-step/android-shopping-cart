package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니화면_타이틀과_아이콘이_보인다() {
        // given
        composeTestRule.setContent {
            ProductListScreen(
                cartItems = emptyList()
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithContentDescription("ShoppingCart")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니화면_상품목록이_보인다() {
        // given
        val cartItems = List(5) {
            Product(
                name = "PET보틀 - ${it + 1}",
                price = 10000,
                imageUrl = "https://picsum.photos/500"
            )
        }
        composeTestRule.setContent {
            ProductListScreen(
                cartItems = cartItems
            )
        }

        // then
        cartItems.forEach { item ->
            composeTestRule
                .onNodeWithText(item.name)
                .assertIsDisplayed()
        }
    }
}
