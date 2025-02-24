package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.ShoppingCartAppBar
import nextstep.shoppingcart.common.ShoppingCartButton
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyCartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(
    onBackPressed: () -> Unit,
    onButtonClick: () -> Unit,
) {

    CartScreen(
        totalPrice = Cart.totalPrice,
        cartItems = Cart.items,
        onBackPressed = onBackPressed,
        onButtonClick = onButtonClick,
        onRemoveClick = { Cart.removeAll(it.product) },
        onPlusClick = { Cart.addOne(it.product)} ,
        onMinusClick = { Cart.removeOne(it.product)} ,
    )
}

@Composable
fun CartScreen(
    totalPrice: Int,
    cartItems: List<CartItem>,
    onBackPressed: () -> Unit,
    onButtonClick: () -> Unit,
    onRemoveClick: (CartItem) -> Unit,
    onPlusClick: (CartItem) -> Unit,
    onMinusClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartAppBar(
                title = stringResource(R.string.shopping_cart),
                onBackPressed = onBackPressed
            )
        },
        bottomBar = {
            ShoppingCartButton(
                onClick = onButtonClick,
                text = stringResource(R.string.order_format_price_won, totalPrice)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentPadding = PaddingValues(18.dp)
        ) {
            items(cartItems, key = { it.product.id }) { cartItem ->
                CartProductItem(
                    cartItem = cartItem,
                    onCloseClick = { onRemoveClick(cartItem) },
                    onPlusClick = { onPlusClick(cartItem) },
                    onMinusClick = { onMinusClick(cartItem) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            cartItems = listOf(dummyCartItem, dummyCartItem),
            onBackPressed = {},
            onButtonClick = {},
            totalPrice = 12345,
            onRemoveClick = {},
            onPlusClick = {},
            onMinusClick = {}
        )
    }
}