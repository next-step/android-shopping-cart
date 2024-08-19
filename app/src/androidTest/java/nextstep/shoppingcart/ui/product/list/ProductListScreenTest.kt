package nextstep.shoppingcart.ui.product.list

import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import org.junit.Rule
import org.junit.Test

class ProductListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun 장바구니_담기_버튼으로_최초_상품_추가_후_상품_수량_조절기가_노출된다() {
        composeTestRule.setContent {
            val eventListener =
                remember {
                    { event: ProductListEvent ->
                        when (event) {
                            is ProductListEvent.OnProductCardClick -> {
                            }

                            is ProductListEvent.OnCartClick -> {
                            }

                            is ProductListEvent.OnArrToCartClick -> {
                            }
                        }
                    }
                }

            ProductListScreen(
                products = emptyList(),
                onProductListEvent = eventListener,
            )

            composeTestRule
                .onAllNodesWithTag(context.getString(R.string.test_tag_product_cart_add))
                .onFirst()
                .performClick()

            composeTestRule
                .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector))
                .onFirst()
                .isDisplayed()
        }
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_추가_시_상품_수량이_증가된다() {
        composeTestRule.setContent {
            val eventListener =
                remember {
                    { event: ProductListEvent ->
                        when (event) {
                            is ProductListEvent.OnProductCardClick -> {
                            }

                            is ProductListEvent.OnCartClick -> {
                            }

                            is ProductListEvent.OnArrToCartClick -> {
                            }
                        }
                    }
                }

            ProductListScreen(
                products = emptyList(),
                onProductListEvent = eventListener,
            )
        }

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_add))
            .onFirst()
            .performClick()

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_quantity))
            .onFirst()
            .assertTextEquals("2")
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_감소_시_상품_수량이_감소된다() {
        composeTestRule.setContent {
            val eventListener =
                remember {
                    { event: ProductListEvent ->
                        when (event) {
                            is ProductListEvent.OnProductCardClick -> {
                            }

                            is ProductListEvent.OnCartClick -> {
                            }

                            is ProductListEvent.OnArrToCartClick -> {
                            }
                        }
                    }
                }

            ProductListScreen(
                products = emptyList(),
                onProductListEvent = eventListener,
            )
        }

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .onFirst()
            .performClick()

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_quantity))
            .onFirst()
            .assertTextEquals("1")
    }

    @Test
    fun 상품이_1개일_때_상품_수량_감소_시_조절기가_사라지고_장바구니_담기_버튼이_된다() {
        composeTestRule.setContent {
            val eventListener =
                remember {
                    { event: ProductListEvent ->
                        when (event) {
                            is ProductListEvent.OnProductCardClick -> {
                            }

                            is ProductListEvent.OnCartClick -> {
                            }

                            is ProductListEvent.OnArrToCartClick -> {
                            }
                        }
                    }
                }

            ProductListScreen(
                products = emptyList(),
                onProductListEvent = eventListener,
            )
        }

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .onFirst()
            .performClick()

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector))
            .onFirst()
            .isNotDisplayed()

        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_product_cart_add))
            .onFirst()
            .isDisplayed()
    }
}
