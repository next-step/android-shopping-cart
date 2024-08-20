package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoTopAppBar
import nextstep.shoppingcart.ui.model.Cart

@Composable
fun ProductCartListScreen(modifier: Modifier = Modifier) {
    var cartItems by remember {
        mutableStateOf(Cart.items)
    }
    val isCartEmpty by remember {
        derivedStateOf {
            cartItems.isEmpty()
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DinoTopAppBar(
                text = stringResource(R.string.product_cart_list_title),
                navigationBack = true
            )
        }
    ) { paddingValues ->
        if (isCartEmpty) {
            ProductCartListEmpty(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
            )
        } else {
            ProductCartListSuccess(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues),
                cartItems = cartItems,
                onQuantityChange = { cartItem, newQuantity ->
                    cartItems = if (cartItem.count > newQuantity) {
                        Cart.removeOne(cartItem.product)
                    } else {
                        Cart.addOne(cartItem.product)
                    }
                },
                onClearClick = { cartItem ->
                    cartItems = Cart.removeAll(cartItem.product)
                },
                onBottomCtaClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun ProductCartListScreenPreview() {
    ProductCartListScreen()
}
