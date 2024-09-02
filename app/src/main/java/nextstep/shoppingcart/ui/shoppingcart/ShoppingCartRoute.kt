package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.data.Cart.addOne
import nextstep.shoppingcart.data.Cart.findCartProductById
import nextstep.shoppingcart.data.Cart.items
import nextstep.shoppingcart.data.Cart.removeAll
import nextstep.shoppingcart.data.Cart.removeOne
import nextstep.shoppingcart.data.Cart.totalPrice

@Composable
fun ShoppingCartRoute(
    onBackClick: () -> Unit,
) {
    var cartProducts by remember { mutableStateOf(items) }
    var total by remember { mutableLongStateOf(totalPrice) }

    ShoppingCartScreen(
        cartProducts = cartProducts,
        total = total,
        onBackClick = onBackClick,
        onRemoveClick = { cartProductId ->
            removeAll(findCartProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
        onAddClick = { cartProductId ->
            addOne(findCartProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
        onSubtractClick = { cartProductId ->
            removeOne(findCartProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
    )
}
