package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.component.CartProductItem
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.testdouble.FakeCartDataSourceImpl
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        val cartItem = CartItem(
            product = Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imageUrl = "",
            ),
            count = 100
        )

        // when
        composeTestRule.setContent {
            CartProductItem(
                cartItem = cartItem,
                onClickDeleteItemButton = {},
                onClickIncreaseCountButton = {},
                onClickDecreaseCountButton = {},
            )
        }

        // then
        composeTestRule.onNodeWithText("100,000원")
            .assertExists()
    }

    @Test
    fun 아이템_제거_아이콘을_클릭하여_담긴_상품을_제거할_수_있다() {
        // given
        val items = mutableStateListOf(CartItem(
            product = Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imageUrl = "",
            ),
            count = 100
        ),
            CartItem(
                product = Product(
                    id = 2,
                    name = "상품2",
                    price = 2000,
                    imageUrl = "",
                ),
                count = 200
            ))
        val cartDataSource = FakeCartDataSourceImpl(items)

        composeTestRule.setContent {
            CartScreen(
                cartItems = cartDataSource.items,
                totalPrice = 0,
                popBackStack = {},
                deleteItem = { cartDataSource.removeOne(it.product) },
                increaseItemCount = {},
                decreaseItemCount = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("1")
            .assertExists()

        composeTestRule
            .onNodeWithTag("1deleteButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("1")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        val cartItems = mutableStateListOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 80
            )
        )
        val cartDataSource = FakeCartDataSourceImpl(cartItems)

        composeTestRule.setContent {
            CartScreen(
                cartItems = cartDataSource.items,
                totalPrice = cartDataSource.totalPrice,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = { cartDataSource.addOne(it.product) },
                decreaseItemCount = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithText("80")
            .assertExists()

        composeTestRule
            .onNodeWithText("80,000원")
            .assertExists()

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("81")
            .assertExists()

        composeTestRule
            .onNodeWithText("81,000원")
            .assertExists()
    }

    @Test
    fun 장바구니에_담은_상품의_개수가_99개면_증가_버튼은_비활성화_된다() {
        // given
        val cartItems = mutableStateListOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 98
            )
        )
        val cartDataSource = FakeCartDataSourceImpl(cartItems)

        // when
        composeTestRule.setContent {
            CartScreen(
                cartItems = cartDataSource.items,
                totalPrice = 0,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = { cartDataSource.addOne(it.product) },
                decreaseItemCount = {},
            )
        }

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .assertIsEnabled()

        composeTestRule
            .onNodeWithTag("1increaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("1increaseButton")
            .assertIsNotEnabled()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        val cartItems = mutableStateListOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 100
            )
        )
        val cartDataSource = FakeCartDataSourceImpl(cartItems)

        composeTestRule.setContent {
            CartScreen(
                cartItems = cartDataSource.items,
                totalPrice = cartDataSource.totalPrice,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = {},
                decreaseItemCount = { cartDataSource.removeOne(it.product) },
            )
        }

        // when
        composeTestRule
            .onNodeWithText("99")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("99,000원")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("1decreaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("99")
            .assertExists()

        composeTestRule
            .onNodeWithText("99,000원")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given
        val cartItems = mutableStateListOf(
            CartItem(
                product = Product(
                    id = 1,
                    name = "상품1",
                    price = 1000,
                    imageUrl = "",
                ),
                count = 1
            )
        )
        val cartDataSource = FakeCartDataSourceImpl(cartItems)

        composeTestRule.setContent {
            CartScreen(
                cartItems = cartItems,
                totalPrice = cartDataSource.totalPrice,
                popBackStack = {},
                deleteItem = {},
                increaseItemCount = {},
                decreaseItemCount = { cartDataSource.removeOne(it.product) },
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("1")
            .assertExists()

        composeTestRule
            .onNodeWithTag("1decreaseButton")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("1")
            .assertDoesNotExist()
    }
}
