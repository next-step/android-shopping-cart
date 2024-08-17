package nextstep.shoppingcart.ui.cart

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.FakeCart
import nextstep.shoppingcart.data.ShoppingCart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private lateinit var cart: ShoppingCart

    @Test
    fun 주문버튼에_장바구니에_담긴_총_상품의_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val cart =
                FakeCart().apply {
                    add(
                        Product(
                            id = 1,
                            name = "상품1",
                            price = 1000,
                            imgUrl = "https://image.com",
                        ),
                    )
                }
            val totalPrice = cart.totalPrice

            CartScreen(
                items = cart.items,
                totalPrice = totalPrice,
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = {},
            )
        }
        // when

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_order_btn))
            .assertExists()
            .assertTextContains("주문하기(1,000원)")
    }

    @Test
    fun 상품수량이_증가하였을_때_주문버튼에_변경된_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val cart =
                FakeCart(
                    _items =
                        mutableListOf<CartItem>().apply {
                            add(
                                CartItem(
                                    product =
                                        Product(
                                            id = 1,
                                            name = "상품1",
                                            price = 1000,
                                            imgUrl = "https://image.com",
                                        ),
                                    quantity = 1,
                                ),
                            )
                        },
                    incrementQuantity = true,
                )
            var totalPrice by remember { mutableStateOf(cart.totalPrice) }

            CartScreen(
                items = cart.items,
                totalPrice = totalPrice,
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {
                    cart.add(it)
                    totalPrice = cart.totalPrice
                },
                onRemoveClick = {},
            )
        }
        // when
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_add))
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_order_btn))
            .assertExists()
            .assertTextContains("주문하기(2,000원)")
    }

    @Test
    fun 상품수량이_감소하였을_때_주문버튼에_변경된_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val cart =
                FakeCart(
                    _items =
                        mutableListOf<CartItem>().apply {
                            add(
                                CartItem(
                                    product =
                                        Product(
                                            id = 1,
                                            name = "상품1",
                                            price = 1000,
                                            imgUrl = "https://image.com",
                                        ),
                                    quantity = 2,
                                ),
                            )
                        },
                    decrementQuantity = true,
                )
            var totalPrice by remember { mutableStateOf(cart.totalPrice) }

            CartScreen(
                items = cart.items,
                totalPrice = totalPrice,
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = {
                    cart.remove(it)
                    totalPrice = cart.totalPrice
                },
            )
        }
        // when
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_order_btn))
            .assertExists()
            .assertTextContains("주문하기(1,000원)")
    }

    // 상품 주문 취소
    @Test
    fun 상품주문_취소_클릭하면_상품이_삭제된다() {
        composeTestRule.setContent {
            val cart =
                FakeCart().apply {
                    add(
                        Product(
                            id = 1,
                            name = "상품1",
                            price = 1000,
                            imgUrl = "https://image.com",
                        ),
                    )
                }
            var items by remember { mutableStateOf(cart.items) }

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = { item ->
                    items = cart.cancel(item)
                },
                onAddClick = {},
                onRemoveClick = {},
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_cart_card_cancel))
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_cart_card))
            .assertCountEquals(0)
    }

    @Test
    fun 상품수량이_1인_담긴_상품을_감소시켰을_떄_상품이_삭제된다() {
        // given
        composeTestRule.setContent {
            val cart =
                FakeCart(
                    _items =
                        mutableListOf<CartItem>().apply {
                            add(
                                CartItem(
                                    product =
                                        Product(
                                            id = 1,
                                            name = "상품1",
                                            price = 1000,
                                            imgUrl = "https://image.com",
                                        ),
                                    quantity = 1,
                                ),
                            )
                        },
                    decrementQuantity = true,
                )
            var items by remember { mutableStateOf(cart.items) }

            CartScreen(
                items = items,
                totalPrice = cart.totalPrice,
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = { items = cart.remove(it) },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_cart_card))
            .assertCountEquals(0)
    }
}
