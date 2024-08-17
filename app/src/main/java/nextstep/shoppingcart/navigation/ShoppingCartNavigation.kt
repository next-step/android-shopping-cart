package nextstep.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shopping.cart.ShoppingCartScreen


fun NavController.navigateToShoppingCartScreen() =
    this.navigate(ShoppingRoute.SHOPPING_CART)

fun NavGraphBuilder.shoppingCart(
    onClickNavigateBack: () -> Unit
) {
    composable(ShoppingRoute.SHOPPING_CART) {
        ShoppingCartScreen(
            onClickNavigateBack = onClickNavigateBack
        )
    }
}
