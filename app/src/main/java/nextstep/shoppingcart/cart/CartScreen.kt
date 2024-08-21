package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.component.CartItemCard
import nextstep.shoppingcart.cart.component.CartScreenBottomBar
import nextstep.shoppingcart.common.component.NextStepTopAppBar
import nextstep.shoppingcart.common.model.CartItem
import nextstep.shoppingcart.common.model.dummyProducts

@Composable
internal fun CartScreen(
    cartItems: List<CartItem>,
    totalPrice: Int,
    onCountAddClick: (CartItem) -> Unit,
    onCountMinusClick: (CartItem) -> Unit,
    onCartItemDeleteClick: (CartItem) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NextStepTopAppBar(
                title = stringResource(id = R.string.cart_screen_title),
                onBackClick = onBackClick
            )
        },
        content = { paddingValues ->
            CartContent(
                cartItems = cartItems,
                onCountAddClick = onCountAddClick,
                onCountMinusClick = onCountMinusClick,
                onCartItemDeleteClick = onCartItemDeleteClick,
                modifier = Modifier
                    .padding(paddingValues = paddingValues)
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
            )
        },
        bottomBar = {
            CartScreenBottomBar(
                totalPrice = totalPrice,
                onOrderButtonClick = {},
            )
        }
    )
}

@Composable
private fun CartContent(
    cartItems: List<CartItem>,
    onCountAddClick: (CartItem) -> Unit,
    onCountMinusClick: (CartItem) -> Unit,
    onCartItemDeleteClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = cartItems,
            key = { item -> item.product.id }
        ) { cartItem ->
            CartItemCard(
                cartItem = cartItem,
                onCloseClick = { onCartItemDeleteClick(cartItem) },
                onCountAddClick = { onCountAddClick(cartItem) },
                onCountMinusClick = { onCountMinusClick(cartItem) })
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    val cartItems by remember { mutableStateOf(dummyProducts.map { CartItem(it, count = 1) }) }

    CartScreen(
        cartItems = cartItems,
        totalPrice = cartItems.sumOf { it.totalPrice },
        onCountAddClick = {},
        onCountMinusClick = {},
        onCartItemDeleteClick = {},
        onBackClick = {},
    )
}
