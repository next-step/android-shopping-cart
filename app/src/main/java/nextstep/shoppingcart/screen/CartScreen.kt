package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.products
import nextstep.shoppingcart.utils.formatPrice
import nextstep.shoppingcart.view.CartProductItem
import nextstep.shoppingcart.view.DefaultButton
import nextstep.shoppingcart.view.DefaultNavigationBackTopBar

@Composable
fun CartScreen(
    onClickBack: () -> Unit,
    onClickOrder: () -> Unit
) {
    var cartItems by remember { mutableStateOf(Cart.items) }
    val totalPrice by remember(cartItems) { mutableIntStateOf(Cart.totalPrice) }

    Scaffold(
        topBar = {
            DefaultNavigationBackTopBar(
                title = stringResource(id = R.string.cart_top_bar_title),
                onClickBack = onClickBack
            )
        }
    ) { paddingValues ->
        CartContent(
            cartItems = cartItems,
            totalPrice = totalPrice,
            modifier = Modifier
                .padding(paddingValues),
            onClickOrder = onClickOrder,
            onClickRemoveOne = { cartItem ->
                cartItems = Cart.removeOne(cartItem.product)
            },
            onClickAddOne = { cartItem ->
                cartItems = Cart.addOne(cartItem.product)
            },
            onClickRemoveAll = { cartItem ->
                cartItems = Cart.removeAll(cartItem.product)
            }
        )
    }
}

@Composable
private fun CartContent(
    cartItems: List<CartItem>,
    totalPrice: Int,
    modifier: Modifier = Modifier,
    onClickOrder: () -> Unit = { },
    onClickRemoveOne: (CartItem) -> Unit = { },
    onClickAddOne: (CartItem) -> Unit = { },
    onClickRemoveAll: (CartItem) -> Unit = { },
) {
    Box(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cartItems) { cartItem ->
                CartProductItem(
                    cartItem = cartItem,
                    onClickRemoveOne = { onClickRemoveOne(cartItem) },
                    onClickAddOne = { onClickAddOne(cartItem) },
                    onClickRemoveAll = { onClickRemoveAll(cartItem) }
                )
            }
        }

        DefaultButton(
            text = stringResource(
                id = R.string.cart_order_button,
                totalPrice.formatPrice()
            ),
            onClick = onClickOrder,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartContentPreview() {
    CartContent(
        cartItems = listOf(
            CartItem(product = products[0], count = 2),
            CartItem(product = products[1], count = 3),
            CartItem(product = products[2], count = 1),
            CartItem(product = products[3], count = 1),
            CartItem(product = products[4], count = 1),
            CartItem(product = products[5], count = 1),
            CartItem(product = products[6], count = 1),
        ),
        totalPrice = 40000,
        modifier = Modifier
    )
}
