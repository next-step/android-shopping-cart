package nextstep.shoppingcart.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.catalog.widget.CatalogContent
import nextstep.shoppingcart.catalog.widget.CatalogTopBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.DataUtil.dummyProducts
import nextstep.shoppingcart.util.DataUtil.getProducts

@Composable
fun CatalogRoute(
    navigateToDetail: () -> Unit,
    navigateToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    var products by remember { mutableStateOf(listOf<Product>()) }

    LaunchedEffect(Unit) {
        products = getProducts()
    }

    CatalogScreen(
        products = products,
        navigateToDetail = navigateToDetail,
        navigateToCart = navigateToCart,
        modifier = modifier,
    )
}

@Composable
fun CatalogScreen(
    products: List<Product>,
    navigateToDetail: () -> Unit,
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
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun CatalogScreenPreview() {
    ShoppingCartTheme {
        CatalogScreen(
            products = dummyProducts,
            navigateToDetail = {},
            navigateToCart = {},
        )
    }
}