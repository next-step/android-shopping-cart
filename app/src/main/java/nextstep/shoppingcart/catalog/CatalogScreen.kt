package nextstep.shoppingcart.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.data.CartDataSource
import nextstep.shoppingcart.cart.data.CartDataSourceImpl
import nextstep.shoppingcart.catalog.widget.CatalogContent
import nextstep.shoppingcart.catalog.widget.CatalogTopBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.DataUtil.dummyProducts

@Composable
fun CatalogScreen(
    products: List<Product>,
    cartDataSource: CartDataSource,
    navigateToDetail: (Product) -> Unit,
    navigateToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { CatalogTopBar(navigateToCart = navigateToCart) },
    ) { paddingValues ->
        CatalogContent(
            products = products,
            navigateToDetail = navigateToDetail,
            cartDataSource = cartDataSource,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Preview
@Composable
private fun CatalogScreenPreview() {
    ShoppingCartTheme {
        CatalogScreen(
            products = dummyProducts,
            cartDataSource = CartDataSourceImpl,
            navigateToDetail = {},
            navigateToCart = {},
        )
    }
}