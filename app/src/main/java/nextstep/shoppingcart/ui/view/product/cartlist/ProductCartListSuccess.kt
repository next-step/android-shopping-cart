package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoBottomCta
import nextstep.shoppingcart.ui.model.Cart
import nextstep.shoppingcart.ui.model.CartItem

@Composable
fun ProductCartListSuccess(
    cartItems: List<CartItem>,
    onQuantityChange: (CartItem, Int) -> Unit,
    onClearClick: (CartItem) -> Unit,
    onBottomCtaClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val totalPrice by remember(cartItems) {
        mutableLongStateOf(Cart.totalPrice)
    }
    Box(
        modifier = modifier
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.size(18.dp))
            }
            items(
                items = cartItems,
                key = { item -> item.product.name },
            ) { item ->
                ProductCartListItem(
                    modifier = Modifier.padding(horizontal = 18.dp),
                    product = item.product,
                    quantity = item.count,
                    onQuantityChange = { newQuantity ->
                        onQuantityChange(item, newQuantity)
                    },
                    onClearClick = {
                        onClearClick(item)
                    }
                )
                Spacer(modifier = Modifier.size(18.dp))
            }
        }
        DinoBottomCta(
            ctaText = stringResource(R.string.product_cart_list_order_button, totalPrice),
            onClick = onBottomCtaClick,
        )
    }

}
