package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.assertIsDisplayed
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import org.junit.Rule
import org.junit.Test

class CartItemViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val dummyProduct = Product(
        name = "Test Product",
        price = 1000,
        imageUrl = "https://example.com/image1.jpg"
    )

    @Test
    fun 장바구니에_상품명이_표시된다() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    onItemRemoved = {},
                    content = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Test Product").assertExists()
    }

    @Test
    fun 장바구니에_상품가격이_표시된다() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    onItemRemoved = {},
                    content = {}
                )
            }
        }

        composeTestRule.onNodeWithText("1,000원").assertExists()
    }

    @Test
    fun 장바구니에_상품_수량이_표시된다() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    onItemRemoved = {},
                    content = {
                        CartItemCountButton(
                            product = dummyProduct,
                            itemCount = 1,
                            onAddClicked = {},
                            onRemoveClicked = {},
                            buttonClickState = false,
                            setButtonClickState = { },
                            modifier = Modifier
                                .padding(
                                    start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                                    dimensionResource(id = R.dimen.cart_item_quantity_padding)
                                )
                        )
                    }
                )
            }
        }

        composeTestRule.onNodeWithText("1").assertExists()
    }

    @Test
    fun 장바구니에_상품_이미지가_표시된다() {
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    onItemRemoved = {},
                    content = {}
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Test Product").assertIsDisplayed()
    }

    @Test
    fun 장바구니에서_상품_삭제_버튼을_삭제_콜백이_호출된다() {
        var isRemoveClicked = false
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    onItemRemoved = { isRemoveClicked = true },
                    content = {
                        CartItemCountButton(
                            product = dummyProduct,
                            itemCount = 1,
                            onAddClicked = {},
                            onRemoveClicked = {},
                            buttonClickState = false,
                            setButtonClickState = { },
                            modifier = Modifier
                                .padding(
                                    start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                                    dimensionResource(id = R.dimen.cart_item_quantity_padding)
                                )
                        )
                    }
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Delete Test Product").performClick()
        assert(isRemoveClicked)
    }
}
