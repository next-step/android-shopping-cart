package nextstep.shoppingcart.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        var cartItems by remember { mutableStateOf(Cart.items) }
        var totalPrice by remember { mutableIntStateOf(Cart.totalPrice) }

        CartScreen(
            cartItems = cartItems,
            totalPrice = totalPrice,
            onCountAddClick = {
                cartItems = Cart.addOne(it.product)
                totalPrice = Cart.totalPrice
            },
            onCountMinusClick = {
                cartItems = Cart.removeOne(it.product)
                totalPrice = Cart.totalPrice
            },
            onCartItemDeleteClick = {
                cartItems = Cart.removeAll(it.product)
                totalPrice = Cart.totalPrice
            },
            onBackClick = onBackClick
        )
    }
}