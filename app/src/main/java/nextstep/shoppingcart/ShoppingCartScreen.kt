package nextstep.shoppingcart

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.component.cart.CartTopBar

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CartTopBar(
                onNavigationClick = onNavigationClick
            )
        }
    ) {

    }
}


@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onNavigationClick = {})
}