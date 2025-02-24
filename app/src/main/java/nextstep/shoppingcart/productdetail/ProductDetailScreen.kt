package nextstep.shoppingcart.productdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productdetail.component.ProductDetailContent
import nextstep.shoppingcart.productdetail.model.ProductDetailUiState
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
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
                    TopAppBar(
                        title = { Text(text = "상품 상세") },
                        navigationIcon = {
                            Icon(
                                modifier = Modifier
                                    .clickable { onBackButtonClick() }
                                    .padding(16.dp),
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "상품 상세 뒤로가기 버튼"
                            )
                        },
                    )
                },
                bottomBar = {
                    Button(
                        shape = MaterialTheme.shapes.large,
                        onClick = { navigateToCart(uiState.product.productId) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .navigationBarsPadding()
                            .height(54.dp),
                    ) {
                        Text("장바구니 담기", fontSize = 20.sp)
                    }
                }
            ) { contentPadding ->
                ProductDetailContent(
                    modifier = Modifier
                        .padding(contentPadding),
                    product = uiState.product,
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
                price = "10000",
                productId = "id1"
            )
        ), {}, {})
    }
}
