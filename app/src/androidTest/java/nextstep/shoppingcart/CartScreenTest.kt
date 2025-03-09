package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.list.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val items = mutableStateOf(emptyList<CartItem>())
    private val totalPrice = mutableStateOf(0)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CartScreen(
                cartItems = items.value,
                totalPrice = totalPrice.value,
                onClickItemRemove = {
                    val newList = items.value.toMutableList()
                    newList.removeAt(it)
                    items.value = newList
                    totalPrice.value = items.value.sumOf { it.totalPrice }
                },
                onChangeItemCount = { id, count ->
                    val newList = items.value.toMutableList()
                    if (count == 0) {
                        newList.removeAt(id)
                    } else {
                        newList[id] = items.value[id].copy(count = count)
                    }
                    items.value = newList
                    totalPrice.value = items.value.sumOf { it.totalPrice }
                },
                onBack = {},
            )
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        totalPrice.value = 50000

        // then
        composeTestRule.onNodeWithText("주문하기(50,000원)").assertExists()
    }

    @Test
    fun 플러스_버튼을_눌러_담긴_상품의_수량을_증가시키면_해당_상품_가격에_반영된다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 1,
            )
        )

        // when
        composeTestRule.onNodeWithText("+").performClick()

        // then
        composeTestRule.onNodeWithText("2").assertExists()
        composeTestRule.onNodeWithText("20,000원").assertExists()
    }

    @Test
    fun 마이너스_버튼을_눌러담긴_상품의_수량을_감소시키면_해당_상품_가격에_반영된다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 2,
            )
        )

        // when
        composeTestRule.onNodeWithText("−").performClick()

        // then
        composeTestRule.onNodeWithText("1").assertExists()
        composeTestRule.onNodeWithText("10,000원").assertExists()
    }

    @Test
    fun 마이너스_버튼을_눌러_담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 1,
            )
        )

        // when
        composeTestRule.onAllNodesWithText("−")[0].performClick()

        // then
        composeTestRule.onNodeWithText("PET보틀 어쩌구").assertDoesNotExist()
    }

    @Test
    fun x버튼을_누르면_담긴_상품을_제거할_수_있다() {
        // given
        items.value = listOf(
            CartItem(
                product = Product(
                    id = 0,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀 어쩌구",
                    price = 10000
                ),
                count = 1,
            )
        )

        // when
        composeTestRule.onNodeWithContentDescription("삭제").performClick()

        // then
        composeTestRule.onNodeWithText("PET보틀 어쩌구").assertDoesNotExist()
    }
}
