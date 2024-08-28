package nextstep.shoppingcart.productlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.productlist.component.ProductListScreenContent
import nextstep.shoppingcart.productlist.component.ProductListScreenTopBar
import java.util.UUID

@Composable
internal fun ProductListScreen(
    products: List<ProductListScreenItem>,
    onProductClick: (ProductListScreenItem) -> Unit,
    onCartClick: () -> Unit,
    onCountAddClick: (ProductListScreenItem) -> Unit,
    onCountMinusClick: (ProductListScreenItem) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ProductListScreenTopBar(onCartClick = onCartClick)
        },
        content = { paddingValues ->
            ProductListScreenContent(
                paddingValues = paddingValues,
                products = products,
                onProductClick = onProductClick,
                onCountAddClick = onCountAddClick,
                onCountMinusClick = onCountMinusClick,
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
                ProductListScreenItem(
                    product = Product(
                        id = UUID.randomUUID().toString(),
                        name = "PET보틀 - 정사각형 모양",
                        10000,
                        imageUrl = "https://picsum.photos/500"
                    ),
                    count = 0,
                )

            }.distinctBy { it.product.id },
            onProductClick = {},
            onCartClick = {},
            onCountAddClick = {},
            onCountMinusClick = {},
        )
    }
}