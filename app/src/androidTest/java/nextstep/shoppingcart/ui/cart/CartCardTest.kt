package nextstep.shoppingcart.ui.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import org.junit.Rule
import org.junit.Test

class CartCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun 장바구니에_담긴_상품의_이름과_주문가격을_확인할_수_있다() {
        // given
        composeTestRule.setContent {
            val product =
                Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imgUrl = "https://example.com/image.jpg",
                )
            val quantity = 2
            CartCard(
                cartItem =
                    CartItem(
                        product = product,
                        quantity = quantity,
                    ),
                onCancel = {},
                onAddQuantityClick = {},
                onRemoveQuantityClick = {},
            )
        }

        // when

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_card_product_name))
            .assertTextContains("상품1")

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_card_price))
            .assertTextContains("2,000원")
    }

    @Test
    fun 상품수량이_증가하였을_때_주문가격이_변경된다() {
        // given
        composeTestRule.setContent {
            val product =
                Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imgUrl = "https://example.com/image.jpg",
                )
            var quantity by remember { mutableStateOf(2) }
            CartCard(
                cartItem =
                    CartItem(
                        product = product,
                        quantity = quantity,
                    ),
                onCancel = {},
                onAddQuantityClick = { quantity++ },
                onRemoveQuantityClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_add))
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_card_price))
            .assertTextContains("3,000원")
    }

    @Test
    fun 상품수량이_감소하였을_때_주문가격이_변경된다() {
        // given
        composeTestRule.setContent {
            val product =
                Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imgUrl = "https://example.com/image.jpg",
                )
            var quantity by remember { mutableStateOf(2) }
            CartCard(
                cartItem =
                    CartItem(
                        product = product,
                        quantity = quantity,
                    ),
                onCancel = {},
                onAddQuantityClick = {},
                onRemoveQuantityClick = { quantity-- },
            )
        }

        // when
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_card_price))
            .assertTextContains("1,000원")
    }
}
