package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.runtime.Composable
import nextstep.shoppingcart.data.dummyProducts

@Composable
fun ShoppingListRoute(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
) {
    val products = dummyProducts

    ShoppingListScreen(
        products = products,
        onShoppingCartClick = onShoppingCartClick,
        onItemClick = onItemClick,
    )
}
