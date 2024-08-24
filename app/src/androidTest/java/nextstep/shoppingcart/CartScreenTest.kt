package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.model.Cart
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.view.product.cartlist.ProductCartListScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    val product = Product(
        name = "상품1",
        price = 10000L,
        imageUrl = "https://example.com/image.jpg"
    )

    @Before
    fun setUp() {
        Cart.clear()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // Given
        Cart.addOne(product)
        composeTestRule.setContent {
            ProductCartListScreen()
        }

        // Then
        composeTestRule.onNodeWithText("주문하기(10,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // Given
        Cart.addOne(product)
        composeTestRule.setContent {
            ProductCartListScreen()
        }

        // When
        composeTestRule.onNodeWithContentDescription("삭제 버튼")
            .performClick()

        // Then
        composeTestRule.onNodeWithText("상품1")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // Given
        Cart.addOne(product)
        composeTestRule.setContent {
            ProductCartListScreen()
        }

        // When
        composeTestRule.onNodeWithText("+")
            .performClick()

        // Then
        composeTestRule.onNodeWithText("주문하기(20,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // Given
        Cart.addOne(product)
        Cart.addOne(product)
        composeTestRule.setContent {
            ProductCartListScreen()
        }

        // When
        composeTestRule.onNodeWithText("-")
            .performClick()

        // Then
        composeTestRule.onNodeWithText("주문하기(10,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // Given
        Cart.addOne(product)
        composeTestRule.setContent {
            ProductCartListScreen()
        }

        // When
        composeTestRule.onNodeWithText("-")
            .performClick()

        // Then
        composeTestRule.onNodeWithText("상품1")
            .assertDoesNotExist()
    }
}
