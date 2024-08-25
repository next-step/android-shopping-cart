package nextstep.shoppingcart.productlist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.common.model.Product
import org.junit.Rule
import org.junit.Test
import java.util.UUID

class ProductListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니화면_타이틀과_아이콘이_보인다() {
        // given
        composeTestRule.setContent {
            ProductListScreen(
                products = emptyList(),
                onProductClick = {},
                onCartClick = {},
                onCountAddClick = {},
                onCountMinusClick = {},
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
            ProductListScreenItem(
                product = Product(
                    id = UUID.randomUUID().toString(),
                    name = "PET보틀 - ${it + 1}",
                    price = 10000,
                    imageUrl = "https://picsum.photos/500"
                ),
                count = 0,
            )
        }
        composeTestRule.setContent {
            ProductListScreen(
                products = cartItems,
                onProductClick = {},
                onCartClick = {},
                onCountAddClick = {},
                onCountMinusClick = {},
            )
        }

        // then
        cartItems.forEach { item ->
            composeTestRule
                .onNodeWithText(item.product.name)
                .assertIsDisplayed()
        }
    }
}
