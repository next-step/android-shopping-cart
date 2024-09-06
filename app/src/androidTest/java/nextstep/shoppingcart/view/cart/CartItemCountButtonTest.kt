package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.ItemCountButton
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import org.junit.Rule
import org.junit.Test

class CartItemCountButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val dummyProduct = Product(
        name = "Test Product",
        price = 1000,
        imageUrl = "https://example.com/image1.jpg"
    )

    @Test
    fun 장바구니에서_상품_수량_추가_버튼을_누르면_추가_콜백이_호출된다() {
        var isAddClicked = false
        Cart.clear()
        Cart.addOne(dummyProduct)
        composeTestRule.setContent {
            ShoppingCartTheme {
                ItemCountButton(
                    product = dummyProduct,
                    itemCount = Cart.getCountByProductName(dummyProduct.name),
                    onAddClicked = { isAddClicked = true },
                    onRemoveClicked = { },
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                            dimensionResource(id = R.dimen.cart_item_quantity_padding)
                        )
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Add Test Product").performClick()
        assert(isAddClicked)
    }

    @Test
    fun 장바구니에서_상품_수량_감소_버튼을_누르면_감소_콜백이_호출된다() {
        var isRemoveOneClicked = false
        composeTestRule.setContent {
            ShoppingCartTheme {
                ItemCountButton(
                    product = dummyProduct,
                    itemCount = 1,
                    onAddClicked = { },
                    onRemoveClicked = { isRemoveOneClicked = true },
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                            dimensionResource(id = R.dimen.cart_item_quantity_padding)
                        )
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Cart Remove Test Product").performClick()
        assert(isRemoveOneClicked)
    }
}
