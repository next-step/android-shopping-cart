package nextstep.shoppingcart.productlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.component.ProductListContent
import nextstep.shoppingcart.productlist.component.ProductListTopBar
import java.util.UUID

@Composable
internal fun ProductListScreen(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ProductListTopBar(onCartClick = onCartClick)
        },
        content = { paddingValues ->
            ProductListContent(
                paddingValues, products, onProductClick
            )
        }
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(
            products = List(20) {
                Product(
                    id = UUID.randomUUID().toString(),
                    name = "PET보틀 - 정사각형 모양",
                    10000,
                    imageUrl = "https://picsum.photos/500"
                )
            }.distinctBy { it.id },
            onProductClick = {},
            onCartClick = {},
        )
    }
}