package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartList(
    cartItems: List<CartItem>,
    onClickItemRemove: (id: Int) -> Unit,
    onChangeItemCount: (id: Int, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = cartItems,
            key = { it.product.id },
        ) {
            CartListItem(
                modifier = Modifier.fillMaxWidth(),
                cartItem = it,
                onClickRemove = {
                    onClickItemRemove(it.product.id)
                },
                onChangeCount = { count ->
                    onChangeItemCount(it.product.id, count)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartListPreview() {
    ShoppingCartTheme {
        CartList(
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
            onClickItemRemove = {},
            onChangeItemCount = { _, _ -> }
        )
    }
}
