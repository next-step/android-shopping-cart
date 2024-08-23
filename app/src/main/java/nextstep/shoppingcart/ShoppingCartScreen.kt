package nextstep.shoppingcart

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.component.cart.CartTopBar

@Composable
fun ShoppingCartScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CartTopBar(
                onBackClick = onBackClick
            )
        }
    ) {

    }
}


@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onBackClick = {})
}