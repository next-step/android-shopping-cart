package nextstep.shoppingcart

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import nextstep.shoppingcart.catalog.CatalogScreen
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.testdouble.FakeCartDataSourceImpl
import org.junit.Rule
import org.junit.Test

class CatalogScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `상품이_장바구니에_담겨_있으면_상품_수량_조절_버튼이_표시된다`() {
        // given
        val product = Product(
            id = 1,
            name = "상품1",
            price = 1000,
            imageUrl = "",
        )
        val cartItems = mutableStateListOf(
            CartItem(
                product = product,
                count = 1
            )
        )
        val cartDataSource = FakeCartDataSourceImpl(cartItems)

        // when
        composeTestRule.setContent {
            CatalogScreen(
                products = listOf(product),
                cartDataSource = cartDataSource,
                navigateToDetail = {},
                navigateToCart = {},
            )
        }

        // then
        composeTestRule.onNodeWithTag("1AddButton", true)
            .assertDoesNotExist()

        composeTestRule.onNodeWithTag("1AdjustButton", true)
            .assertExists()
    }

    @Test
    fun `상품이_장바구니에_담겨_있지_않으면_상품_담기_버튼이_표시된다`() {
        // given
        val product = Product(
            id = 1,
            name = "상품1",
            price = 1000,
            imageUrl = "",
        )
        val cartDataSource = FakeCartDataSourceImpl()

        // when
        composeTestRule.setContent {
            CatalogScreen(
                products = listOf(product),
                cartDataSource = cartDataSource,
                navigateToDetail = {},
                navigateToCart = {},
            )
        }

        // then
        composeTestRule.onNodeWithTag("1AdjustButton", true)
            .assertDoesNotExist()

        composeTestRule.onNodeWithTag("1AddButton", true)
            .assertExists()
    }
}