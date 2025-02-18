package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.product.Product
import nextstep.shoppingcart.model.product.ProductListUiState
import nextstep.shoppingcart.ui.component.ProductListContents
import nextstep.shoppingcart.ui.component.ProductListTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(listUiState: ProductListUiState, modifier: Modifier = Modifier) {
    when (listUiState) {

        ProductListUiState.Loading -> {
            CircularProgressIndicator()
        }

        is ProductListUiState.Products -> {
            Scaffold(
                modifier = modifier
                    .fillMaxSize(),
                topBar = {
                    ProductListTopBar(topBarTitle = "상품 목록", rightIcon = Icons.Filled.ShoppingCart)
                },
            ) { contentPadding ->
                ProductListContents(
                    modifier = Modifier
                        .padding(contentPadding)
                        .padding(horizontal = 12.dp),
                    productItems = listUiState.products
                )
            }
        }

        ProductListUiState.Error -> {
            // Error 뷰
        }

        ProductListUiState.Empty -> {
            // Empty 뷰
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    val uiState = ProductListUiState.Products(getProductsTestData())
    ShoppingCartTheme {
        ProductListScreen(uiState)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenLoadingPreview() {
    val uiState = ProductListUiState.Loading
    ShoppingCartTheme {
        ProductListScreen(uiState)
    }
}

fun getProductsTestData(): List<Product> {
    val list = mutableListOf<Product>()
    for (i in 1..30) {
        list.add(
            Product(
                name = "PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
                imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
                price = "10000",
                productId = "id${i}"
            )
        )
    }
    return list.toList()
}
