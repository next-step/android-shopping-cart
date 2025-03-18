package nextstep.shoppingcart

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.ProductListScreen
import nextstep.shoppingcart.productlist.model.ProductListUiState
import nextstep.shoppingcart.productlist.model.ProductWithCartInfo
import org.junit.Rule
import org.junit.Test

class ProductListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품_리스트가_없을_경우에는_텅_글자가_노출된다() {
        // given
        val uiState = ProductListUiState.Empty

        // when
        composeTestRule.setContent {
            ProductListScreen(
                uiState = uiState,
                navigateToProductDetail = {},
                navigateToCart = {},
                onDecreaseProductQuantity = {},
                onIncreaseProductQuantity = {},
                modifier = Modifier
            )
        }

        // then
        composeTestRule
            .onNodeWithText("텅")
            .assertExists()
    }

    @Test
    fun 상품_리스트_로드_실패시_다시시도_버튼이_노출된다() {
        // given
        val uiState = ProductListUiState.Error

        // when
        composeTestRule.setContent {
            ProductListScreen(
                uiState = uiState,
                navigateToProductDetail = {},
                navigateToCart = {},
                onDecreaseProductQuantity = {},
                onIncreaseProductQuantity = {},
                modifier = Modifier
            )
        }

        // then
        composeTestRule
            .onNodeWithText("다시 시도")
            .assertExists()
    }

    @Test
    fun 상품_리스트_로드_성공시_상품이_노출된다() {
        // given
        val uiState = ProductListUiState.Success(
            products = productTestDataList.map { ProductWithCartInfo(it) }
        )

        // when
        composeTestRule.setContent {
            ProductListScreen(
                uiState = uiState,
                navigateToProductDetail = {},
                navigateToCart = {},
                onDecreaseProductQuantity = {},
                onIncreaseProductQuantity = {},
                modifier = Modifier
            )
        }

        // then
        composeTestRule
            .onNodeWithText("테스트0")
            .assertExists()
    }

    companion object {
        private val productTestDataList = List(30) { i ->
            Product(
                name = "테스트$i",
                imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
                price = 10000 + i,
                productId = "id${i}"
            )
        }
    }
}

