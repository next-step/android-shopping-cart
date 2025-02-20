package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.widget.CartContent
import nextstep.shoppingcart.cart.widget.CartTopBar
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(
    currentCartItems: List<CartItem>,
    popBackStack: () -> Unit,
    deleteItem: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    var cartItems by remember { mutableStateOf(currentCartItems) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CartTopBar(popBackStack)
        },
    ) { paddingValue ->
        CartContent(
            cartItems = cartItems,
            onClickDeleteItemButton = {
                deleteItem(it)
                cartItems = cartItems.filter { cartItem -> cartItem.product.id != it.id }
            },
            onClickIncreaseCountButton = {},
            onClickDecreaseCountButton = {},
            modifier = Modifier.padding(paddingValue),
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            currentCartItems = listOf(
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
        )
    }
}
