package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.widget.CartContent
import nextstep.shoppingcart.cart.widget.CartTopBar
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    popBackStack: () -> Unit,
    deleteItem: (CartItem) -> Unit,
    increaseItemCount: (CartItem) -> Unit,
    decreaseItemCount: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CartTopBar(popBackStack)
        },
    ) { paddingValue ->
        CartContent(
            cartItems = cartItems,
            onClickDeleteItemButton = { deleteItem(it) },
            onClickIncreaseCountButton = { increaseItemCount(it) },
            onClickDecreaseCountButton = { decreaseItemCount(it) },
            modifier = Modifier.padding(paddingValue),
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            cartItems = listOf(
                CartItem(
                    product = Product(
                        id = 1,
                        name = "상품1",
                        price = 1000,
                        imageUrl = "",
                    ),
                    count = 100
                ),
                CartItem(
                    product = Product(
                        id = 2,
                        name = "상품2",
                        price = 2000,
                        imageUrl = "",
                    ),
                    count = 200
                ),
            ),
            popBackStack = {},
            deleteItem = {},
            increaseItemCount = {},
            decreaseItemCount = {},
        )
    }
}