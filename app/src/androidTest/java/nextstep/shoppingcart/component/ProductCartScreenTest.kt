package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.ProductCartScreen
import org.junit.Rule
import org.junit.Test

class ProductCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val cart = Cart(
        items = listOf(
            CartItem(
                product = Product(
                    id = 1,
                    imageUrl = "",
                    name = "상품1",
                    price = 2000,
                ),
                count = 3
            ),
            CartItem(
                product = Product(
                    id = 2,
                    imageUrl = "",
                    name = "상품2",
                    price = 1000,
                ),
                count = 1
            )
        )
    )

    @Test
    fun `뒤로가기_버튼을_클릭할_수_있다`() {
        var clicked = false
        composeTestRule
            .setContent {
                ProductCartScreen(
                    cartItems = cart.items,
                    totalPrice = cart.totalPrice,
                    orderButtonEnabled = true,
                    onBackButtonClick = { clicked = true },
                    onRemoveClick = { },
                    onIncreaseClick = { },
                    onDecreaseClick = { },
                    onOrderClick = { },
                )
            }

        composeTestRule
            .onNodeWithTag("back_navigation")
            .performClick()

        assert(clicked == true)
    }


    @Test
    fun `담긴_상품_가격의_총합이_주문하기_버튼에_노출된다`() {
        val totalPrice = cart.totalPrice

        composeTestRule
            .setContent {
                ProductCartScreen(
                    cartItems = cart.items,
                    totalPrice = totalPrice,
                    orderButtonEnabled = true,
                    onBackButtonClick = { },
                    onRemoveClick = { },
                    onIncreaseClick = { },
                    onDecreaseClick = { },
                    onOrderClick = { },
                )
            }

        composeTestRule
            .onNodeWithText("7,000원", substring = true)
            .assertIsDisplayed()
    }

    @Test
    fun `특정_항목의_제거_버튼을_클릭할_수_있다`() {
        var removeProduct: Product? = null

        composeTestRule
            .setContent {
                ProductCartScreen(
                    cartItems = cart.items,
                    totalPrice = cart.totalPrice,
                    orderButtonEnabled = true,
                    onBackButtonClick = { },
                    onRemoveClick = { removeProduct = it },
                    onIncreaseClick = { },
                    onDecreaseClick = { },
                    onOrderClick = { },
                )
            }

        composeTestRule
            .onAllNodesWithTag("remove_button")
            .onFirst()
            .performClick()

        assert(removeProduct?.name == "상품1")
    }

    @Test
    fun `특정_항목의_수량조절_버튼을_클릭할_수_있다`() {
        var increaseProduct: Product? = null
        var decreaseProduct: Product? = null

        composeTestRule
            .setContent {
                ProductCartScreen(
                    cartItems = cart.items,
                    totalPrice = cart.totalPrice,
                    orderButtonEnabled = true,
                    onBackButtonClick = { },
                    onRemoveClick = { },
                    onIncreaseClick = { increaseProduct = it },
                    onDecreaseClick = { decreaseProduct = it },
                    onOrderClick = { },
                )
            }
        composeTestRule
            .onAllNodesWithTag("increase_button")
            .onFirst()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("decrease_button")[1]
            .performClick()

        assert(increaseProduct?.name == "상품1")
        assert(decreaseProduct?.name == "상품2")
    }
}
