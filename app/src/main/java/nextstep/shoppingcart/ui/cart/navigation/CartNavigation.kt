package nextstep.shoppingcart.ui.cart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.cart.CartRoute

const val CART_ROUTE = "cart"

fun NavHostController.navigateToCart() {
    navigate(CART_ROUTE)
}

fun NavGraphBuilder.cartScreen(onNavigateUp: () -> Unit) {
    composable(CART_ROUTE) {
        CartRoute(
            onNavigateUp = onNavigateUp,
        )
    }
}
