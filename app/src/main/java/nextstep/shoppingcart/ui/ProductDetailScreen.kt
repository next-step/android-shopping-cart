package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.component.BackNavigationAppBar
import nextstep.shoppingcart.ui.component.BlueButtonBottomBar
import nextstep.shoppingcart.ui.component.ProductDetailContent
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductDetailScreen(
    product: Product,
    onBackButtonClick: () -> Unit,
    onAddCartClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackNavigationAppBar(
                title = stringResource(R.string.product_detail),
                onBackButtonClick = onBackButtonClick,
            )
        },
        content = { innerPadding ->
            ProductDetailContent(
                modifier = Modifier.padding(innerPadding),
                product = product,
            )
        },
        bottomBar = {
            BlueButtonBottomBar(
                text = stringResource(R.string.add_shopping_cart),
                onClick = { onAddCartClick(product) },
            )
        }
    )
}


@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = ProductRepository.getProductById(1),
            onAddCartClick = {},
            onBackButtonClick = {}
        )
    }
}
