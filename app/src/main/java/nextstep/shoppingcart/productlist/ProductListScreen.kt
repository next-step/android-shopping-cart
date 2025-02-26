package nextstep.shoppingcart.productlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.ProductsTestData
import nextstep.shoppingcart.productlist.component.ProductListContents
import nextstep.shoppingcart.productlist.model.ProductListUiState
import nextstep.shoppingcart.ui.component.CommonEmptyScreen
import nextstep.shoppingcart.ui.component.CommonErrorScreen
import nextstep.shoppingcart.ui.component.CommonLoading
import nextstep.shoppingcart.ui.component.ProductCenterAlignedTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    uiState: ProductListUiState,
    navigateToProductDetail: (String) -> Unit,
    navigateToCart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (uiState) {

        ProductListUiState.Loading -> CommonLoading()

        is ProductListUiState.Success -> {
            Scaffold(
                modifier = modifier
                    .fillMaxSize(),
                topBar = {
                    ProductCenterAlignedTopBar(
                        topBarTitle = "상품 목록",
                        rightIcon = Icons.Filled.ShoppingCart,
                        onRightIconClicked = { navigateToCart() })
                },
            ) { contentPadding ->
                ProductListContents(
                    modifier = Modifier
                        .padding(contentPadding)
                        .padding(horizontal = 12.dp),
                    productItems = uiState.products,
                    navigateToProductDetail = { id -> navigateToProductDetail(id) },
                )
            }
        }

        ProductListUiState.Error -> CommonErrorScreen(onRetryButtonClick = {})

        ProductListUiState.Empty -> CommonEmptyScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    val uiState = ProductListUiState.Success(ProductsTestData.productTestDataList)
    ShoppingCartTheme {
        ProductListScreen(uiState, {}, {})
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenLoadingPreview() {
    val uiState = ProductListUiState.Loading
    ShoppingCartTheme {
        ProductListScreen(uiState, {}, {})
    }
}

