package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.component.CartProductItem
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        val cartItem = CartItem(
            product = Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imageUrl = "",
            ),
            count = 100
        )

        // when
        composeTestRule.setContent {
            CartProductItem(
                cartItem = cartItem,
                onClickDeleteItemButton = {},
                onClickIncreaseCountButton = {},
                onClickDecreaseCountButton = {},
            )
        }

        // then
        composeTestRule.onNodeWithText("100,000원")
            .assertExists()
    }

    @Test
    fun 아이템_제거_아이콘을_클릭하여_담긴_상품을_제거할_수_있다() {
        // given
        val cartItems = listOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 100
            ),
            CartItem(
                product = Product(
                    id = 2,
                    name = "상품2",
                    price = 2000,
                    imageUrl = "",
                ),
                count = 200
            )
        )

        composeTestRule.setContent {
            CartScreen(
                currentCartItems = cartItems,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("1")
            .assertExists()

        composeTestRule
            .onNodeWithTag("1deleteButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("1")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        val cartItems = listOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 100
            )
        )

        composeTestRule.setContent {
            CartScreen(
                currentCartItems = cartItems,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithText("101")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("101,000원")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("101")
            .assertExists()

        composeTestRule
            .onNodeWithText("101,000원")
            .assertExists()
    }

    @Test
    fun 장바구니에_담은_상품의_개수가_99개면_증가_버튼은_비활성화_된다() {
        // given
        val cartItems = listOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 98
            )
        )

        // when
        composeTestRule.setContent {
            CartScreen(
                currentCartItems = cartItems,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = {},
            )
        }

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .assertIsEnabled()

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("1increaseButton")
            .assertIsNotEnabled()
    }
}
