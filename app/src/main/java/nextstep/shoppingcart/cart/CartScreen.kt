package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.widget.CartContent
import nextstep.shoppingcart.cart.widget.CartTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartRoute(modifier: Modifier = Modifier) {
    CartScreen(modifier = modifier)
}

@Composable
fun CartScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { CartTopBar() }
    ) { paddingValue ->
        CartContent(modifier = Modifier.padding(paddingValue))
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen()
    }
}