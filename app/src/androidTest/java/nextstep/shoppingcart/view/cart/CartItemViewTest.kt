package nextstep.shoppingcart.view.cart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.assertIsDisplayed
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
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = {},
                    onRemoveClicked = {}
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
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = {},
                    onRemoveClicked = {}
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
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = {},
                    onRemoveClicked = {}
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
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = {},
                    onRemoveClicked = {}
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
                    itemCount = 1,
                    onItemRemoved = { isRemoveClicked = true },
                    onAddClicked = {},
                    onRemoveClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Delete").performClick()
        assert(isRemoveClicked)
    }

    @Test
    fun 장바구니에서_상품_수량_추가_버튼을_누르면_추가_콜백이_호출된다() {
        var isAddClicked = false
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = { isAddClicked = true },
                    onRemoveClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Add").performClick()
        assert(isAddClicked)
    }

    @Test
    fun 장바구니에서_상품_수량_감소_버튼을_누르면_감소_콜백이_호출된다() {
        var isRemoveOneClicked = false
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartItemView(
                    product = dummyProduct,
                    itemCount = 1,
                    onItemRemoved = {},
                    onAddClicked = {},
                    onRemoveClicked = { isRemoveOneClicked = true }
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Remove").performClick()
        assert(isRemoveOneClicked)
    }
}
