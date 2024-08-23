package nextstep.shoppingcart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import nextstep.shoppingcart.model.Cart.totalPrice
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var fakeCartRepository: FakeCartRepository
    private val items = listOf(
        CartItem(
            Product(
                name = "iPhone 15 Pro",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_500_000
            ),
            count = 2
        ), CartItem(
            Product(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000,
            ),
            count = 1
        )
    )

    @Before
    fun setUp() {
        fakeCartRepository = FakeCartRepository()
        fakeCartRepository.setInitialItems(items)

    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given
        composeTestRule.setContent {
            val cartItems by remember {
                mutableStateOf(fakeCartRepository.cartItems)
            }
            ShoppingCartScreen(
                cartItem = cartItems,
                onItemCloseClick = {},
                onItemMinusClick = {},
                onItemPlusClick = {},
                onOrderClick = {},
                onBackClick = {}
            )
        }
        // then
        val totalPrice = "주문하기(4,900,000원)"
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(
                key = SemanticsProperties.Role,
                expectedValue = Role.Button
            ) and hasText(totalPrice)
        ).assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given
        composeTestRule.setContent {
            var cartItems by remember { mutableStateOf(fakeCartRepository.cartItems) }
            ShoppingCartScreen(
                cartItem = cartItems,
                onItemCloseClick = {
                    fakeCartRepository.removeAll(it)
                    cartItems = fakeCartRepository.cartItems
                },
                onItemMinusClick = {},
                onItemPlusClick = {},
                onOrderClick = {},
                onBackClick = {},
            )
        }
        // when
        composeTestRule
            .onNodeWithContentDescription(label = "shoppingCartList")
            .performScrollToIndex(1)

        composeTestRule
            .onNodeWithContentDescription(label = "iPhone 15 Pro Max close")
            .performClick()


        // then
        composeTestRule
            .onNodeWithText("iPhone 15 Pro Max")
            .assertDoesNotExist()

        val totalPrice ="주문하기(3,000,000원)"
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(
                key = SemanticsProperties.Role,
                expectedValue = Role.Button
            ) and hasText(totalPrice)
        ).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given
        composeTestRule.setContent {
            var cartItems by remember { mutableStateOf(fakeCartRepository.cartItems) }
            ShoppingCartScreen(
                cartItem = cartItems,
                onItemCloseClick = {},
                onItemMinusClick = {},
                onItemPlusClick = {
                    fakeCartRepository.addOne(it)
                    cartItems = fakeCartRepository.cartItems
                },
                onOrderClick = {},
                onBackClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription(label = "shoppingCartList")
            .performScrollToIndex(1)

        composeTestRule
            .onNodeWithContentDescription(label = "iPhone 15 Pro Max plus")
            .performClick()

        // then
        val totalPrice = "주문하기(6,800,000원)"
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(
                key = SemanticsProperties.Role,
                expectedValue = Role.Button
            ) and hasText(totalPrice)
        ).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given
        composeTestRule.setContent {
            var cartItems by remember { mutableStateOf(fakeCartRepository.cartItems) }
            ShoppingCartScreen(
                cartItem = cartItems,
                onItemCloseClick = {},
                onItemMinusClick = {
                    fakeCartRepository.removeOne(it)
                    cartItems = fakeCartRepository.cartItems
                },
                onItemPlusClick = {},
                onOrderClick = {},
                onBackClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription(label = "shoppingCartList")
            .performScrollToIndex(0)

        composeTestRule
            .onNodeWithContentDescription(label = "iPhone 15 Pro minus")
            .performClick()

        // then
        val totalPrice = "주문하기(3,400,000원)"
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(
                key = SemanticsProperties.Role,
                expectedValue = Role.Button
            ) and hasText(totalPrice)
        ).assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {

        // given
        composeTestRule.setContent {
            var cartItems by remember { mutableStateOf(fakeCartRepository.cartItems) }
            ShoppingCartScreen(
                cartItem = cartItems,
                onItemCloseClick = {},
                onItemMinusClick = {
                    fakeCartRepository.removeOne(it)
                    cartItems = fakeCartRepository.cartItems
                },
                onItemPlusClick = {},
                onOrderClick = {},
                onBackClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription(label = "shoppingCartList")
            .performScrollToIndex(1)

        composeTestRule
            .onNodeWithContentDescription(label = "iPhone 15 Pro Max minus")
            .performClick()

        composeTestRule
            .onNodeWithText("iPhone 15 Pro Max")
            .assertDoesNotExist()

        // then
        val totalPrice = "주문하기(3,000,000원)"
        composeTestRule.onNode(
            SemanticsMatcher.expectValue(
                key = SemanticsProperties.Role,
                expectedValue = Role.Button
            ) and hasText(totalPrice)
        ).assertExists()
    }


}