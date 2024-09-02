package nextstep.shoppingcart.shoppinglist.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import org.junit.Rule
import org.junit.Test

class ShoppingCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given:
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 1,
                ),
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = { id ->
                        cartProducts = cartProducts.map { cartItem ->
                            if (cartItem.product.id == id) cartItem.copy(count = cartItem.count + 1) else cartItem
                        }
                    },
                    onSubtractClick = {},
                )
            }
        }

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingCountBarAddIcon").performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingCartItemSum").assertTextEquals(
            "200원"
        )
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given:
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 5,
                ),
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = {},
                    onSubtractClick = { id ->
                        cartProducts = cartProducts
                            .map { cartItem ->
                                if (cartItem.product.id == id)
                                    cartItem.copy(count = cartItem.count - 1) else cartItem
                            }
                            .filter { cartItem -> cartItem.count > 0 }
                    }
                )
            }
        }

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingCountBarSubtractIcon").performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingCartItemSum").assertTextEquals(
            "400원"
        )
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_감소시키면_상품이_삭제된다() {
        // given:
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 2,
                ),
                CartItem(
                    product = Product(
                        id = 1L,
                        name = "테스트2",
                        imageUrl = "",
                        price = 500
                    ),
                    count = 1,
                ),
            ),
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = {},
                    onSubtractClick = { id ->
                        cartProducts = cartProducts
                            .map { cartItem ->
                                if (cartItem.product.id == id)
                                    cartItem.copy(count = cartItem.count - 1) else cartItem
                            }
                            .filter { cartItem -> cartItem.count > 0 }
                    }
                )
            }
        }

        // when:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCountBarSubtractIcon")[0].performClick()
        composeTestRule.onAllNodesWithContentDescription("ShoppingCountBarSubtractIcon")[1].performClick()

        // then:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCartItem").assertCountEquals(1)
    }

    @Test
    fun 장바구니의_총_가격을_볼수있다() {
        val cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 1,
                ),
                CartItem(
                    product = Product(
                        id = 1L,
                        name = "테스트2",
                        imageUrl = "",
                        price = 500
                    ),
                    count = 2,
                ),
            )
        )

        // when:
        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = {},
                    onSubtractClick = {},
                )
            }
        }

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingButton")
            .assertTextEquals("주문하기(1,100)원")
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_장바구니_가격에_반영된다() {
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 1,
                ),
                CartItem(
                    product = Product(
                        id = 1L,
                        name = "테스트2",
                        imageUrl = "",
                        price = 500
                    ),
                    count = 2,
                ),
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = { id ->
                        cartProducts = cartProducts.map { cartItem ->
                            if (cartItem.product.id == id) cartItem.copy(count = cartItem.count + 1) else cartItem
                        }
                    },
                    onSubtractClick = {},
                )
            }
        }

        // when:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCountBarAddIcon").onFirst()
            .performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingButton")
            .assertTextEquals("주문하기(1,200)원")
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_장바구니_가격에_반영된다() {
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 1,
                ),
                CartItem(
                    product = Product(
                        id = 1L,
                        name = "테스트2",
                        imageUrl = "",
                        price = 500
                    ),
                    count = 2,
                ),
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = {},
                    onAddClick = {},
                    onSubtractClick = { id ->
                        cartProducts = cartProducts.filter { it.product.id != id }
                    },
                )
            }
        }

        // when:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCountBarSubtractIcon").onFirst()
            .performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingButton")
            .assertTextEquals("주문하기(1,000)원")
    }

    @Test
    fun 상품_삭제_버튼을_클릭할_경우_해당_종류의_상품이_목록에서_삭제된다() {
        var cartProducts by mutableStateOf(
            listOf(
                CartItem(
                    product = Product(
                        id = 0L,
                        name = "테스트1",
                        imageUrl = "",
                        price = 100
                    ),
                    count = 4,
                ),
                CartItem(
                    product = Product(
                        id = 1L,
                        name = "테스트2",
                        imageUrl = "",
                        price = 500
                    ),
                    count = 2,
                ),
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingCartScreen(
                    cartProducts = cartProducts,
                    total = cartProducts.sumOf { it.totalPrice },
                    onBackClick = {},
                    onRemoveClick = { id ->
                        cartProducts = cartProducts.filter { it.product.id != id }
                    },
                    onAddClick = {},
                    onSubtractClick = {},
                )
            }
        }

        // when:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCartItemHeaderCloseButton")
            .onFirst()
            .performClick()

        // then:
        composeTestRule.onAllNodesWithContentDescription("ShoppingCartItem").assertCountEquals(1)
    }
}
