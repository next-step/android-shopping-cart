package nextstep.shoppingcart.ui.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.model.CartItem

@Composable
fun CartListItem(
    cartItem: CartItem,
    onRemoveCartItemClick: (CartItem) -> Unit,
    onIncreaseQuantityClick: (CartItem) -> Unit,
    onDecreaseQuantityClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {

}
