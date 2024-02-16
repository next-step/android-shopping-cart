package nextstep.shoppingcart.ui.screen.cart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.cart.CartScreen

const val CartNavigationRoute = "cart"
fun NavGraphBuilder.cartScreen(onClickBack: () -> Unit) {
    composable(route = CartNavigationRoute) {
        CartScreen(onClickBack = onClickBack)
    }
}

fun NavController.navigateToCart() {
    navigate(route = CartNavigationRoute)
}
