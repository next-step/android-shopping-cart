package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.cart.component.CartContent
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.component.ProductBackButtonTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(onBackButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    val cartItem by remember { mutableStateOf(Cart.items) }
    CartScreen(cartItem = cartItem, onBackButtonClick = { onBackButtonClick() })
}

@Composable
private fun CartScreen(
    onBackButtonClick: () -> Unit,
    cartItem: List<CartItem>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ProductBackButtonTopBar(
                title = "장바구니",
                onBackButtonClick = { onBackButtonClick() },
                contentDescription = "장바구니 뒤로가기 버튼"
            )
        },
    ) { contentPadding ->
        //  CartScreen(modifier = Modifier.padding(contentPadding), cartItem)
        CartContent(modifier = modifier.padding(contentPadding), cartItem = cartItem)
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen({})
    }
}
