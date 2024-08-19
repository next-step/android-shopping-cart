package nextstep.shoppingcart.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal fun NavController.navigateCart() {
    navigate(CartRoute)
}

internal fun NavGraphBuilder.cartNavGraph(
    onBackClick: () -> Unit,
) {
    composable<CartRoute> {
        CartScreen(
            products = emptyList(),
            onBackClick = onBackClick
        )
    }
}