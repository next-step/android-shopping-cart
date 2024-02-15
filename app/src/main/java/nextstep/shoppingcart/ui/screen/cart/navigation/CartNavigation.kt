package nextstep.shoppingcart.ui.screen.cart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.cart.CartScreen

const val CartNavigationRoute = "cart"
fun NavGraphBuilder.cartScreen() {
    composable(route = CartNavigationRoute) {
        CartScreen()
    }
}
