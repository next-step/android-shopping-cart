package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.products.ProductsScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val fakeProducts = listOf(
        Product(
            id = 1L,
            name = "product1",
            price = 1000L,
            imageUrl = "https://picsum.photos/200"
        ),
        Product(
            id = 2L,
            name = "product2",
            price = 2000L,
            imageUrl = "https://picsum.photos/200"
        ),
        Product(
            id = 3L,
            name = "product3",
            price = 3000L,
            imageUrl = "https://picsum.photos/200"
        )
    )

    // given
    val cart = Cart

    @Before
    fun setUp() {
        cart.items.clear()
    }

    @Test
    fun 첫_번째_상품을_추가하면_상품이_1개_추가된다() {
        //given
        composeTestRule.setContent {
            ProductsScreen(
                products = fakeProducts,
                onProductClick = {},
                onShoppingCartActionClick = {},
                cartItems = cart.items,
                onProductAddClick = cart::addOne,
                onProductRemoveClick = cart::removeOne
            )
        }

        // when
        composeTestRule.onAllNodesWithContentDescription("상품 첫 추가")[0]
            .performClick()

        // then
        assert(cart.items.size == 1)
        assert(cart.items[0].product == fakeProducts[0])
        assert(cart.items[0].count == 1)
    }

    @Test
    fun 첫_번째_상품을_두_번_추가하면_상품이_2개_추가된다() {
        //given
        composeTestRule.setContent {
            ProductsScreen(
                products = fakeProducts,
                onProductClick = {},
                onShoppingCartActionClick = {},
                cartItems = cart.items,
                onProductAddClick = cart::addOne,
                onProductRemoveClick = cart::removeOne
            )
        }

        // when
        composeTestRule.onAllNodesWithContentDescription("상품 첫 추가")[0]
            .performClick()

        composeTestRule.onNodeWithContentDescription("더하기")
            .performClick()

        // then
        assert(cart.items.size == 1)
        assert(cart.items[0].product == fakeProducts[0])
        assert(cart.items[0].count == 2)
    }


    @Test
    fun 장바구니에_1_3번_상품이_2개씩_담겨있으면_상품_목록_화면에서_상품_개수가_2개가_된다() {
        // given
        cart.apply {
            repeat(2) {
                addOne(fakeProducts[0])
                addOne(fakeProducts[2])
            }
        }

        composeTestRule.setContent {
            ProductsScreen(
                products = fakeProducts,
                onProductClick = {},
                onShoppingCartActionClick = {},
                cartItems = cart.items,
                onProductAddClick = {},
                onProductRemoveClick = {}
            )
        }

        // then
        composeTestRule
            .onAllNodesWithText("2")
            .assertCountEquals(2)
    }

    @Test
    fun 장바구니에_2번_상품이_3개_담겨있을_때_1개_추가하면_상품_목록_화면에서_4개가_된다() {
        // given
        cart.apply {
            repeat(3) {
                addOne(fakeProducts[1])
            }
        }

        composeTestRule.setContent {
            ProductsScreen(
                products = fakeProducts,
                onProductClick = {},
                onShoppingCartActionClick = {},
                cartItems = cart.items,
                onProductAddClick = cart::addOne,
                onProductRemoveClick = {}
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("더하기")
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithText("4")
            .assertCountEquals(1)
    }

    @Test
    fun 장바구니에_2번_상품이_3개_담겨있을_때_두번_빼면_상품_목록_화면에서_1개가_된다() {
        // given
        cart.apply {
            repeat(3) {
                addOne(fakeProducts[1])
            }
        }
        composeTestRule.setContent {
            ProductsScreen(
                products = fakeProducts,
                onProductClick = {},
                onShoppingCartActionClick = {},
                cartItems = cart.items,
                onProductAddClick = {},
                onProductRemoveClick = cart::removeOne
            )
        }

        // when
        composeTestRule.onNodeWithContentDescription("빼기")
            .performClick()
            .performClick()


        // then
        composeTestRule
            .onAllNodesWithText("1")
            .assertCountEquals(1)
    }
}
