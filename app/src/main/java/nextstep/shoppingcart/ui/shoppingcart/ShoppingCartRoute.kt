package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.data.Cart.addOne
import nextstep.shoppingcart.data.Cart.findProductById
import nextstep.shoppingcart.data.Cart.items
import nextstep.shoppingcart.data.Cart.removeAll
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
            removeAll(findProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
        onAddClick = { cartProductId ->
            addOne(findProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
        onSubtractClick = { cartProductId ->
            addOne(findProductById(cartProductId).product)
            cartProducts = items
            total = totalPrice
        },
    )
}
