package nextstep.shoppingcart.ui.shoppinglist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppinglist.ShoppingListRoute
import nextstep.shoppingcart.ui.shoppinglist.navigation.ShoppingListDestination.ROUTE

fun NavGraphBuilder.shoppingListScreen(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
) {
    composable(route = ROUTE) {
        ShoppingListRoute(
            onShoppingCartClick = onShoppingCartClick,
            onItemClick = onItemClick,
        )
    }
}

object ShoppingListDestination {
    const val ROUTE = "ShoppingListScreen"
}
