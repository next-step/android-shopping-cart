package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shopping.cart.ShoppingCartScreen


fun NavGraphBuilder.shoppingCart() {
    composable(ShoppingRoute.SHOPPING_CART) {
        ShoppingCartScreen()
    }
}
