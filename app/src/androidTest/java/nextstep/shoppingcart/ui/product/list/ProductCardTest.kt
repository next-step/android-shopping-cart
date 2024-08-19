package nextstep.shoppingcart.ui.product.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.PRODUCT_LIST_MOCK_DATA
import nextstep.shoppingcart.domain.model.ProductItem
import org.junit.Rule
import org.junit.Test

class ProductCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun 장바구니_담기_버튼으로_최초_상품_추가_후_상품_수량_조절기가_노출된다() {
        composeTestRule.setContent {
            var item by remember {
                mutableStateOf(
                    ProductItem(
                        product = PRODUCT_LIST_MOCK_DATA.first(),
                        isInCart = false,
                        quantity = 0,
                    ),
                )
            }
            ProductCard(
                item = item,
                onCardClick = {},
                onAddToCartClick = {
                    item = item.copy(isInCart = true, quantity = 1)
                },
                onAddQuantityClick = {},
                onRemoveQuantityClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_product_cart_add))
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector),
                useUnmergedTree = true,
            ).assertIsDisplayed()
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_추가_시_상품_수량이_증가된다() {
        composeTestRule.setContent {
            var item by remember {
                mutableStateOf(
                    ProductItem(
                        product = PRODUCT_LIST_MOCK_DATA.first(),
                        isInCart = true,
                        quantity = 1,
                    ),
                )
            }
            ProductCard(
                item = item,
                onCardClick = {},
                onAddToCartClick = {},
                onAddQuantityClick = {
                    item = item.copy(quantity = item.quantity + 1)
                },
                onRemoveQuantityClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector_add),
            ).assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector_quantity),
                useUnmergedTree = true,
            ).assertTextEquals("2")
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_감소_시_상품_수량이_감소된다() {
        composeTestRule.setContent {
            var item by remember {
                mutableStateOf(
                    ProductItem(
                        product = PRODUCT_LIST_MOCK_DATA.first(),
                        isInCart = true,
                        quantity = 2,
                    ),
                )
            }
            ProductCard(
                item = item,
                onCardClick = {},
                onAddToCartClick = {},
                onAddQuantityClick = {},
                onRemoveQuantityClick = {
                    item = item.copy(quantity = item.quantity - 1)
                },
            )
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector_quantity),
                useUnmergedTree = true,
            ).assertTextEquals("1")
    }

    @Test
    fun 상품이_수량이_없어지면_수량_조절기가_사라지고_장바구니_담기_버튼이_노출된다() {
        composeTestRule.setContent {
            var item by remember {
                mutableStateOf(
                    ProductItem(
                        product = PRODUCT_LIST_MOCK_DATA.first(),
                        isInCart = true,
                        quantity = 1,
                    ),
                )
            }
            ProductCard(
                item = item,
                onCardClick = {},
                onAddToCartClick = {},
                onAddQuantityClick = {},
                onRemoveQuantityClick = {
                    item = item.copy(quantity = 0, isInCart = false)
                },
            )
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector))
            .assertIsNotDisplayed()

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_product_cart_add))
            .assertIsDisplayed()
    }
}
