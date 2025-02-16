package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.component.ProductListContent
import nextstep.shoppingcart.ui.component.ProductListTopAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


@Composable
internal fun ProductListScreen(
    productList: List<Product>,
    onTopBarButtonClick: () -> Unit,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProductListTopAppBar(
                onClickButton = onTopBarButtonClick
            )
        },
        content = { innerPadding ->
            ProductListContent(
                modifier = Modifier.padding(innerPadding),
                productList = productList,
                onProductClick = onItemClick
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            productList = ProductRepository.getProductList(),
            onItemClick = {},
            onTopBarButtonClick = {}
        )
    }
}
