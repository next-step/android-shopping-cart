package nextstep.shoppingcart.cart

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.common.model.Cart

internal fun NavController.navigateCart() {
    navigate(CartRoute)
}

internal fun NavGraphBuilder.cartNavGraph(
    onBackClick: () -> Unit,
) {
    composable<CartRoute> {
        CartScreen(
            cartItems = Cart.items,
            onCountAddClick = { Cart.addOne(it.product) },
            onCountMinusClick = { Cart.removeOne(it.product) },
            onCartItemDeleteClick = { Cart.removeAll(it.product) },
            onBackClick = onBackClick
        )
    }
}