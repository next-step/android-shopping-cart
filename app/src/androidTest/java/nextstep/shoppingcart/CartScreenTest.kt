package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Count
import nextstep.shoppingcart.domain.model.Price
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.features.cart.CartScreen
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val snack = Product(
        id = 1,
        name = "과자",
        price = Price.of(2000),
        imageUrl = "",
    )

    @Test
    fun 장바구니에_존재하는_상품의_개수를_추가하면_늘어난_개수가_표시된다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.ONE)))
                )
            }
            CartScreen(
                cart = cart.value,
                onBackClick = {},
                onAddOneClick = { cart.value = cart.value.addOne(it) },
                onRemoveOneClick = {},
                onRemoveAllClick = {}
            )
        }

        // when
        composeTestRule.onNodeWithText("+").performClick()

        // then
        composeTestRule.onNodeWithText("2").assertExists()
    }

    @Test
    fun 장바구니에_존재하는_상품의_개수를_감소하면_감소된_개수가_표시된다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.of(2))))
                )
            }
            CartScreen(
                cart = cart.value,
                onBackClick = {},
                onAddOneClick = {},
                onRemoveOneClick = { cart.value = cart.value.removeOne(it) },
                onRemoveAllClick = {}
            )
        }

        // when
        composeTestRule.onNodeWithText("−").performClick()

        // then
        composeTestRule.onNodeWithText("1").assertExists()
    }

    @Test
    fun 장바구니에_존재하는_상품의_개수가_1개일때_개수를_감소하면_상품이_제거된다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.ONE)))
                )
            }
            CartScreen(
                cart = cart.value,
                onBackClick = {},
                onAddOneClick = {},
                onRemoveOneClick = { cart.value = cart.value.removeOne(it) },
                onRemoveAllClick = {}
            )
        }

        // when
        composeTestRule
            .onNodeWithText("−")
            .performClick()

        // then
        composeTestRule.onNodeWithText(snack.name).assertDoesNotExist()
    }

    @Test
    fun 장바구니에_담은_과자가_여러개여도_제거버튼을_통해_한번에_제거되어_화면에_표시되지_않는다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.of(3))))
                )
            }
            CartScreen(
                cart = cart.value,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onRemoveAllClick = { cart.value = cart.value.removeAll(it) },
                onBackClick = {}
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("장바구니 상품 삭제")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText(snack.name)
            .assertDoesNotExist()
    }

    @Test
    fun 장바구니에_담긴_상품이_하나라도_존재하면_가격의_총합이_주문버튼에_표시되고_버튼이_활성화된다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.ONE)))
                )
            }
            CartScreen(
                cart = cart.value,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onRemoveAllClick = {}, onBackClick = { }
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(2,000원)")
            .assertExists()
            .assertIsEnabled()
    }

    @Test
    fun 장바구니에_담긴_상품이_존재하지_않는다면_주문버튼이_비활성화된다() {
        // given
        composeTestRule.setContent {
            val cart = remember { mutableStateOf(Cart()) }

            CartScreen(
                cart = cart.value,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onRemoveAllClick = {},
                onBackClick = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("주문하기(0원)")
            .assertExists()
            .assertIsNotEnabled()
    }

    @Test
    fun 장바구니의_담긴_상품의_개수를_추가시키면_변경된_총합이_표시된다() {
        // given
        composeTestRule.setContent {
            val cart = remember {
                mutableStateOf(
                    Cart(initialItems = listOf(CartItem(product = snack, count = Count.of(2))))
                )
            }
            CartScreen(
                cart = cart.value,
                onAddOneClick = { cart.value = cart.value.addOne(it) },
                onRemoveOneClick = {},
                onRemoveAllClick = {},
                onBackClick = {}
            )
        }

        // when
        composeTestRule
            .onNodeWithText("+")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("주문하기(6,000원)")
            .assertExists()
    }
}
