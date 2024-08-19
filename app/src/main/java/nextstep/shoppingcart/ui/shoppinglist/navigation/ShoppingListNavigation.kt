package nextstep.shoppingcart.ui.shoppinglist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppinglist.ShoppingListScreen
import nextstep.shoppingcart.ui.shoppinglist.navigation.ShoppingListRoute.ROUTE

fun NavGraphBuilder.shoppingListScreen(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
) {
    composable(route = ROUTE) {
        ShoppingListScreen(
            onShoppingCartClick = onShoppingCartClick,
            onItemClick = onItemClick,
        )
    }
}

fun NavController.navigateToShoppingList() {
    navigate(ROUTE)
}

object ShoppingListRoute {
    const val ROUTE = "ShoppingListScreen"
}
