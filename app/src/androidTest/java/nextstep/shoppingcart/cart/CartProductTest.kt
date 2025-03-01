package nextstep.shoppingcart.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import org.junit.Rule
import org.junit.Test

class CartProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니_상품_이름이_노출된다() {
        val cartItem = CartItem(
            product = Product(
                name = "상품1",
                price = 1000,
                imageUrl = "https://example.com/image1.jpg",
            ),
            count = 1,
        )

        composeTestRule.setContent {
            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithText("상품1")
            .assertExists()
    }

    @Test
    fun 장바구니_상품이_이름이_없으면_상품이름이_노출되지_않는다() {
        val cartItem = CartItem(
            product = Product(
                name = "",
                price = 1000,
                imageUrl = "https://example.com/image1.jpg",
            ),
            count = 1,
        )

        composeTestRule.setContent {
            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithText("상품1")
            .assertDoesNotExist()
    }

    @Test
    fun 장바구니_상품_이미지가_노출된다() {
        val cartItem = CartItem(
            product = Product(
                name = "상품1",
                price = 1000,
                imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            ),
            count = 1,
        )

        composeTestRule.setContent {
            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithContentDescription("Product Image")
            .assertExists()
    }

    @Test
    fun 장바구니_상품_가격이_노출된다() {
        val cartItem = CartItem(
            product = Product(
                name = "상품1",
                price = 1000,
                imageUrl = "https://example.com/image1.jpg",
            ),
            count = 1,
        )

        composeTestRule.setContent {
            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithText("1,000원")
            .assertExists()
    }

    @Test
    fun 장바구니_개수에_맞는_가격이_노출되어야한다() {
        val cartItem = CartItem(
            product = Product(
                name = "상품1",
                price = 1000,
                imageUrl = "",
            ),
            count = 3,
        )

        composeTestRule.setContent {
            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithText("3,000원")
            .assertExists()
    }

    @Test
    fun 더하기_버튼을_누르면_가격이_변경된다() {
        // given
        composeTestRule.setContent {
            var cartItem by remember { mutableStateOf(CartItem(
                product = Product(
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 3,
            )) }

            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {
                    cartItem = cartItem.copy(count = (cartItem.count + 1))
                },
            )
        }

        composeTestRule
            .onNodeWithTag("plus_button")
            .performClick()

        composeTestRule
            .onNodeWithText("4,000원")
            .assertExists()
    }

    @Test
    fun 더하기_버튼을_누르면_개수가_변경된다() {
        // given
        composeTestRule.setContent {
            var cartItem by remember { mutableStateOf(CartItem(
                product = Product(
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 3,
            )) }

            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {},
                onPlusButtonClick = {
                    cartItem = cartItem.copy(count = (cartItem.count + 1))
                },
            )
        }

        composeTestRule
            .onNodeWithTag("plus_button")
            .performClick()

        composeTestRule
            .onNodeWithTag("quantity_text")
            .assertTextEquals("4")
    }

    @Test
    fun 빼기_버튼을_누르면_가격이_변경된다() {
        // given
        composeTestRule.setContent {
            var cartItem by remember { mutableStateOf(CartItem(
                product = Product(
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 3,
            )) }

            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {
                    cartItem = cartItem.copy(count = (cartItem.count - 1))
                },
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("minus_button")
            .performClick()

        composeTestRule
            .onNodeWithText("2,000원")
            .assertExists()
    }

    @Test
    fun 빼기_버튼을_누르면_개수가_변경된다() {
        // given
        composeTestRule.setContent {
            var cartItem by remember { mutableStateOf(CartItem(
                product = Product(
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 3,
            )) }

            CartProduct(
                cartItem = cartItem,
                onDeleteButtonClick = {},
                onMinusButtonClick = {
                    cartItem = cartItem.copy(count = (cartItem.count - 1))
                },
                onPlusButtonClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("minus_button")
            .performClick()

        composeTestRule
            .onNodeWithTag("quantity_text")
            .assertTextEquals("2")
    }
}