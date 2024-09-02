package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R.string.shopping_list_title
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingListLazyVerticalGrid
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingListTopBar
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingListScreen(
    products: List<Product>,
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
    onPutClick: (productId: Long) -> Unit,
    onAddClick: (productId: Long) -> Unit,
    onSubtractClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        ShoppingListTopBar(
            title = stringResource(id = shopping_list_title),
            onShoppingCartClick = onShoppingCartClick,
        )
        ShoppingListLazyVerticalGrid(
            products = products,
            onItemClick = onItemClick,
            onPutClick = onPutClick,
            onAddClick = onAddClick,
            onSubtractClick = onSubtractClick,
        )
    }
}

@Preview
@Composable
private fun ShoppingListScreenPreview() {
    ShoppingListScreen(
        products = dummyProducts,
        onShoppingCartClick = {},
        onItemClick = {},
        onPutClick = {},
        onAddClick = {},
        onSubtractClick = {},
    )
}
