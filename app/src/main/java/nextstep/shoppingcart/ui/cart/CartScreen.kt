package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.CartRepository
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.ui.cart.component.CartItemList
import nextstep.shoppingcart.ui.component.CartButton

@Composable
internal fun CartScreen(onBackClick: () -> Unit) {
    var cart by remember { mutableStateOf(CartRepository.getCart()) }
    CartScreen(
        cart = cart,
        onBackClick = onBackClick,
        onCartDeleteClick = { item ->
            cart = CartRepository.removeAllFromCart(item.product)
        },
        onCartPlusClick = { item ->
            cart = CartRepository.addToCart(item.product)
        },
        onCartMinusClick = { item ->
            cart = CartRepository.removeFromCart(item.product)
        },
        onOrderClick = { /*TODO*/ })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    cart: Cart,
    onBackClick: () -> Unit,
    onCartDeleteClick: (Cart.Item) -> Unit,
    onCartPlusClick: (Cart.Item) -> Unit,
    onCartMinusClick: (Cart.Item) -> Unit,
    onOrderClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.cart_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            CartContent(
                cart = cart,
                onCartDeleteClick = onCartDeleteClick,
                onCartPlusClick = onCartPlusClick,
                onCartMinusClick = onCartMinusClick,
                onOrderClick = onOrderClick,
                modifier = Modifier.padding(innerPadding),
            )
        },
    )
}

@Composable
private fun CartContent(
    cart: Cart,
    onCartDeleteClick: (Cart.Item) -> Unit,
    onCartPlusClick: (Cart.Item) -> Unit,
    onCartMinusClick: (Cart.Item) -> Unit,
    onOrderClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        CartItemList(
            items = cart.items,
            onDeleteClick = onCartDeleteClick,
            onPlusClick = onCartPlusClick,
            onMinusClick = onCartMinusClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        CartButton(
            text = stringResource(id = R.string.cart_order_fmt, cart.totalPrice),
            onClick = onOrderClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    MaterialTheme {
        val cart = Cart(
            items = Products.map { Cart.Item(it, 1) }
        )
        CartScreen(
            cart = cart,
            onBackClick = { },
            onCartDeleteClick = {},
            onCartPlusClick = {},
            onCartMinusClick = {},
            onOrderClick = {},
        )
    }
}
