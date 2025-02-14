package nextstep.shoppingcart.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.ShoppingCartTopBar
import nextstep.shoppingcart.components.ShoppingCartTopBarActionType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun MainScreen(
    products: Products,
    onActionClick: () -> Unit,
    onProductClick: (Product) -> Unit,
) {
    Scaffold(
        topBar = {
            ShoppingCartTopBar(
                title = stringResource(R.string.product_list_top_bar_title),
                action = ShoppingCartTopBarActionType.CART,
                onActionClick = onActionClick,
            )
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) { paddingValues ->
        ProductListScreen(
            products = products,
            onProductClick = onProductClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    ShoppingCartTheme {
        MainScreen(
            products = FakeProductRepository.getAllProducts(),
            onActionClick = {},
            onProductClick = {},
        )
    }
}
