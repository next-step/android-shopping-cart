package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.products
import nextstep.shoppingcart.ui.component.ProductList
import nextstep.shoppingcart.ui.component.ProductListTopBar

@Composable
fun ProductListScreen(
    onCartClick: () -> Unit,
    onProductClick: (Product) -> Unit,
) {
    Scaffold(
        topBar = {
            ProductListTopBar(
                onCartClick = onCartClick,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        ProductList(
            products = products,
            onProductClick = onProductClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}