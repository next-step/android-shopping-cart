package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.data.Products.dummyProducts

@Composable
fun ShoppingListRoute(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
) {
    val products = dummyProducts
    var isVisible by remember { mutableStateOf(true) }

    ShoppingListScreen(
        products = products,
        onShoppingCartClick = onShoppingCartClick,
        onItemClick = onItemClick,
        onAddClick = { isVisible = !isVisible }
    )
}
