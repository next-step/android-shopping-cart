package nextstep.shoppingcart.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.component.CartList
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.common.component.BackTitleAppBar
import nextstep.shoppingcart.common.component.BottomButton
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = remember { mutableStateOf(Cart.items) }
    val totalPrice = remember { mutableIntStateOf(Cart.totalPrice) }

    CartScreen(
        cartItems = items.value,
        totalPrice = totalPrice.intValue,
        onBack = onBack,
        onClickItemRemove = {
            Cart.removeAll(it)
            items.value = Cart.items
            totalPrice.intValue = Cart.totalPrice
        },
        onChangeItemCount = { id, count ->
            Cart.changeCount(id, count)
            items.value = Cart.items
            totalPrice.intValue = Cart.totalPrice
        },
        modifier = modifier.background(Color.White),
    )
}

@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    totalPrice: Int,
    onBack: () -> Unit,
    onClickItemRemove: (id: Int) -> Unit,
    onChangeItemCount: (id: Int, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackTitleAppBar(
                title = stringResource(R.string.cart),
                onBack = onBack
            )
        },
        bottomBar = {
            BottomButton(
                label = stringResource(R.string.order_price_format, totalPrice),
                onClick = {}
            )
        }
    ) { innerPadding ->
        CartList(
            cartItems = cartItems,
            onClickItemRemove = onClickItemRemove,
            onChangeItemCount = onChangeItemCount,
            modifier = Modifier
                .padding(innerPadding)
                .padding(
                    horizontal = 18.dp,
                    vertical = 16.dp
                ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            onBack = {},
            cartItems = listOf(
                CartItem(
                    product = Product(
                        id = 1,
                        imageUrl = "https://picsum.photos/id/2/300/300",
                        name = "PET보틀 어쩌구",
                        price = 10000
                    ),
                    count = 1
                ),
                CartItem(
                    product = Product(
                        id = 2,
                        imageUrl = "https://picsum.photos/id/2/300/300",
                        name = "PET보틀 어쩌구",
                        price = 20000
                    ),
                    count = 1
                ),
                CartItem(
                    product = Product(
                        id = 3,
                        imageUrl = "https://picsum.photos/id/2/300/300",
                        name = "PET보틀 어쩌구",
                        price = 30000
                    ),
                    count = 1
                ),
            ),
            totalPrice = 100000,
            onClickItemRemove = {},
            onChangeItemCount = { _, _ -> },
        )
    }
}
