package nextstep.shoppingcart.productdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productdetail.component.ProductDetailContent
import nextstep.shoppingcart.productdetail.model.ProductDetailUiState
import nextstep.shoppingcart.ui.component.ProductBackButtonTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    uiState: ProductDetailUiState,
    navigateToCart: (String) -> Unit,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text("ProductDetailScreen")
    when (uiState) {
        ProductDetailUiState.Empty -> {
            //TODO Empty View
        }

        ProductDetailUiState.Error -> {
            //TODO Error View
        }

        ProductDetailUiState.Loading -> {
            //TODO Loading View
        }

        is ProductDetailUiState.ProductDetail -> {
            Scaffold(
                modifier = modifier
                    .fillMaxSize(),
                topBar = {
                    ProductBackButtonTopBar(
                        title = "상품 상세",
                        onBackButtonClick = { onBackButtonClick() },
                        contentDescription = "상품 상세 뒤로가기 버튼"
                    )
                },
            ) { contentPadding ->
                ProductDetailContent(
                    modifier = Modifier
                        .padding(contentPadding),
                    product = uiState.product,
                    onAddToCartButtonClick = { navigateToCart(uiState.product.productId) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            ProductDetailUiState.ProductDetail(
                product = Product(
                    name = "PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
                    imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
                    price = 10000,
                    productId = "id1"
                )
            ), {}, {})
    }
}
