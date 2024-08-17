package nextstep.shoppingcart.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.cart.ShoppingCartRoute

const val SHOPPING_CART__ROUTE = "shopping_cart"

fun NavController.navigateToShoppingCart() = navigate(SHOPPING_CART__ROUTE)

fun NavGraphBuilder.shoppingCartScreen(
    onNavigationClick: () -> Unit
) {
    composable(
        route = SHOPPING_CART__ROUTE,
    ) {
        ShoppingCartRoute(onNavigationClick = onNavigationClick)
    }
}
