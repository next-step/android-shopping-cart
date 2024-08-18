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
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private val addButtons
        get() =
            composeTestRule
                .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_add))

    private val removeButtons
        get() =
            composeTestRule
                .onAllNodesWithTag(context.getString(R.string.test_tag_quantity_selector_remove))

    private val cancelButtons
        get() =
            composeTestRule
                .onAllNodesWithTag(context.getString(R.string.test_tag_cart_card_cancel))

    private val orderButton
        get() =
            composeTestRule
                .onNodeWithTag(context.getString(R.string.test_tag_order_btn))

    @Test
    fun 주문버튼에_장바구니에_담긴_총_상품의_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val items =
                listOf(
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

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = {},
            )
        }

        // when && then
        orderButton
            .assertTextContains("주문하기(1,000원)")
    }

    @Test
    fun 상품수량이_증가하였을_때_주문버튼에_변경된_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val initial =
                listOf(
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
            val addedItems = initial.map { item -> item.copy(quantity = item.quantity + 1) }
            var items by remember { mutableStateOf(initial) }

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {
                    assert(it == initial[0].product)
                    items = addedItems
                },
                onRemoveClick = {},
            )
        }
        // when
        addButtons
            .onFirst()
            .performClick()

        // then
        orderButton
            .assertTextContains("주문하기(2,000원)")
    }

    @Test
    fun 상품수량이_감소하였을_때_주문버튼에_변경된_가격이_보여진다() {
        // given
        composeTestRule.setContent {
            val initial =
                listOf(
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
            val removedItems = initial.map { item -> item.copy(quantity = item.quantity - 1) }
            var items by remember { mutableStateOf(initial) }

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = {
                    assert(it == initial[0].product)
                    items = removedItems
                },
            )
        }
        // when
        removeButtons
            .onFirst()
            .performClick()

        // then
        orderButton
            .assertTextContains("주문하기(1,000원)")
    }

    // 상품 주문 취소
    @Test
    fun 상품주문_취소_클릭하면_상품이_삭제된다() {
        composeTestRule.setContent {
            val initial =
                listOf(
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
            var items by remember { mutableStateOf(initial) }

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = { item ->
                    assert(item == initial[0])
                    items = emptyList()
                },
                onAddClick = {},
                onRemoveClick = {},
            )
        }

        // when
        cancelButtons
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
            val initial =
                listOf(
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
            var items by remember { mutableStateOf(initial) }

            CartScreen(
                items = items,
                totalPrice = items.sumOf { it.totalPrice },
                navigateUp = {},
                onCancelClick = {},
                onAddClick = {},
                onRemoveClick = {
                    assert(it == initial[0].product)
                    items = emptyList()
                },
            )
        }

        // when
        removeButtons
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithTag(context.getString(R.string.test_tag_cart_card))
            .assertCountEquals(0)
    }
}
