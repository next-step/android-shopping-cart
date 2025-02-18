package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.cart.CartListScreen
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CartListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `주어진_CartList의_전체_가격이_올바르게_나와야_한다`() {
        //given
        val cartList = listOf(
            Cart(Product(1, "상품1", 1000, ""), 1),
            Cart(Product(2, "상품2", 2000, ""), 2),
            Cart(Product(3, "상품3", 3000, ""), 3),
            Cart(Product(4, "상품4", 4000, ""), 4),
        )
        //when
        composeTestRule.setContent {
            CartListScreen(cartList)
        }

        //then
        composeTestRule
            .onNodeWithText("주문하기(${cartList.sumOf { it.totalPrice }.getFormattedPrice()})")
            .assertIsDisplayed()
    }

    @Test
    fun `주어진_CartList에서_특정상품의_갯수를_추가하였을때_올바르게_추가되어야_한다`() {
        //given
        var cartListState = mutableStateListOf<Cart>().apply {
            addAll(
                listOf(
                    Cart(Product(1, "상품1", 1000, ""), 1),
                    Cart(Product(2, "상품2", 2000, ""), 2),
                    Cart(Product(3, "상품3", 3000, ""), 3),
                    Cart(Product(4, "상품4", 4000, ""), 4),
                )
            )
        }
        val selectCart = cartListState[0]

        composeTestRule.setContent {
            CartListScreen(cartListState, onAdd = { item ->
                cartListState =
                    cartListState.toMutableList().apply {
                        remove(item)
                        add(item.copy(count = item.count + 1))
                    }.toMutableStateList()
            })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${selectCart.product.id}_add_icon")
            .performClick()


        //then
        assertTrue(cartListState.first { it.product.id == selectCart.product.id }.count == (selectCart.count + 1))
    }

    @Test
    fun `주어진_CartList에서_특정상품의_갯수를_제거하였을때_올바르게_제거되어야_한다`() {
        //given
        var cartListState = mutableStateListOf<Cart>().apply {
            addAll(
                listOf(
                    Cart(Product(1, "상품1", 1000, ""), 1),
                    Cart(Product(2, "상품2", 2000, ""), 2),
                    Cart(Product(3, "상품3", 3000, ""), 3),
                )
            )
        }
        val selectCart = cartListState[1]

        composeTestRule.setContent {
            CartListScreen(cartListState,
                onRemove = { item ->
                    cartListState =
                        cartListState.toMutableList().apply {
                            remove(item)
                            add(item.copy(count = item.count - 1))
                        }.filter { it.count != 0 }.toMutableStateList()
                }
            )
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${selectCart.product.id}_remove_icon")
            .performClick()


        //then
        assertTrue(cartListState.first { it.product.id == selectCart.product.id }.count == (selectCart.count - 1))
    }

    @Test
    fun `주어진_CartList에서_특정상품의_갯수를_1개인_상태에서_제거하였을때_삭제되어야_한다`() {
        //given
        var cartListState = mutableStateListOf<Cart>().apply {
            addAll(
                listOf(
                    Cart(Product(1, "상품1", 1000, ""), 1),
                    Cart(Product(2, "상품2", 2000, ""), 2),
                )
            )
        }
        val selectCart = cartListState[0]

        composeTestRule.setContent {
            CartListScreen(cartListState, onRemove = { item ->
                cartListState = cartListState.toMutableList().apply {
                    remove(item)
                    add(item.copy(count = item.count - 1))
                }.filter { it.count != 0 }.toMutableStateList()
            })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${selectCart.product.id}_remove_icon")
            .performClick()


        //then
        assertTrue(cartListState.find { it.product.id == selectCart.product.id } == null)
    }

    @Test
    fun `주어진_CartList에서_특정상품을_삭제하면_리스트에서_삭제되어야_한다`() {
        //given
        var cartListState = mutableStateListOf<Cart>().apply {
            addAll(
                listOf(
                    Cart(Product(1, "상품1", 1000, ""), 1),
                    Cart(Product(2, "상품2", 2000, ""), 2),
                    Cart(Product(3, "상품3", 3000, ""), 3),
                    Cart(Product(4, "상품4", 4000, ""), 4),
                    Cart(Product(5, "상품5", 5000, ""), 5),
                )
            )
        }
        val selectCart = cartListState[3]

        composeTestRule.setContent {
            CartListScreen(cartListState, onDelete = { item ->
                cartListState =
                    cartListState.toMutableList().filter { it != item }.toMutableStateList()
            })
        }

        //when
        composeTestRule
            .onNodeWithContentDescription("${selectCart.product.id}_delete_icon")
            .performClick()


        //then
        assertTrue(cartListState.find { it.product.id == selectCart.product.id } == null)
    }
}