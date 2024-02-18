package nextstep.shoppingcart.ui.product.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import kotlinx.coroutines.test.runTest
import nextstep.shoppingcart.data.productsTestData
import org.junit.Rule
import org.junit.Test

class ProductScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니_버튼을_클릭할_수_있다() {
        // given
        var clicked = false

        composeTestRule.setContent {
            ProductListScreen(
                products = productsTestData,
                onCartClick = { clicked = true },
                onProductAddClick = { },
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
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { },
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
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { },
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
    fun 상품_장바구니_버튼을_클릭할_수_있다() = runTest {
        // given
        var clickedProductId: String? = null

        composeTestRule.setContent {
            ProductListScreen(
                products = productsTestData,
                onCartClick = { },
                onProductAddClick = { clickedProductId = it.id },
                onProductItemClick = { }
            )
        }

        composeTestRule.awaitIdle()

        // when
        composeTestRule
            .onAllNodesWithContentDescription("장바구니 추가")
            .filterToOne(hasParent(hasTestTag(productsTestData[0].id)))
            .performClick()

        // then
        assert(clickedProductId == productsTestData[0].id)
    }
}
