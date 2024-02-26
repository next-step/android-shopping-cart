package nextstep.shoppingcart.ui.product.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import nextstep.shoppingcart.data.productsTestData
import nextstep.shoppingcart.domain.model.Cart
import org.junit.Rule
import org.junit.Test

class ProductListScreenTest {

    private val cart = Cart(emptyList())

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니_버튼을_클릭할_수_있다() {
        // given
        var clicked = false

        composeTestRule.setContent {
            ProductListScreen(
                cart = cart,
                products = productsTestData,
                onCartClick = { clicked = true },
                onProductAddClick = { },
                onProductMinusClick = { },
                onProductItemClick = { }
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()

        // then
        assert(clicked)
    }

    @Test
    fun 현재_상품이_보여야_한다() {
        // given
        composeTestRule.setContent {
            ProductListScreen(
                cart = cart,
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { },
                onProductMinusClick = { },
                onProductItemClick = { }
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("products")
            .performScrollToIndex(0)

        // then
        composeTestRule
            .onNodeWithTag(productsTestData[0].id)
            .assertIsDisplayed()
    }

    @Test
    fun 상품을_클릭할_수_있다() {
        // given
        var clickedProductId: String? = null

        composeTestRule.setContent {
            ProductListScreen(
                cart = cart,
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { },
                onProductMinusClick = { },
                onProductItemClick = { clickedProductId = it.id }
            )
        }

        // when
        composeTestRule
            .onNodeWithTag(productsTestData[0].id)
            .performClick()

        // then
        assert(clickedProductId == productsTestData[0].id)
    }

    @Test
    fun 상품_장바구니_버튼을_클릭할_수_있다() {
        // given
        var clickedProductId: String? = null

        composeTestRule.setContent {
            ProductListScreen(
                cart = cart,
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { clickedProductId = it.id },
                onProductMinusClick = { },
                onProductItemClick = { }
            )
        }

        // when
        composeTestRule
            .onAllNodesWithContentDescription("장바구니 추가")
            .filterToOne(hasParent(hasTestTag(productsTestData[0].id)))
            .performClick()

        // then
        assert(clickedProductId == productsTestData[0].id)
    }

    @Test
    fun 장바구니에_상품이_담겨있다면_상품_갯수만큼_수량이_출력된다() {
        // given
        val cart = cart.copy(
            items = listOf(Cart.Item(productsTestData[0], 5))
        )
        composeTestRule.setContent {
            ProductListScreen(
                cart = cart,
                products = listOf(productsTestData[0]),
                onCartClick = { },
                onProductAddClick = { },
                onProductMinusClick = { },
                onProductItemClick = { }
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("장바구니::아이템수량", true)
            .assertTextEquals("5")
    }
}
