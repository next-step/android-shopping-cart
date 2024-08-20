package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingListLazyVerticalGrid
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingListTopBar

@Composable
fun ShoppingListScreen(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        ShoppingListTopBar(
            title = stringResource(id = R.string.shopping_list_title),
            onShoppingCartClick = onShoppingCartClick,
        )
        ShoppingListLazyVerticalGrid(
            products = dummyProducts,
            onItemClick = onItemClick,
        )
    }
}

@Preview
@Composable
private fun ShoppingListScreenPreview() {
    ShoppingListScreen(
        onShoppingCartClick = {},
        onItemClick = {},
    )
}
