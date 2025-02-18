package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.ui.component.BackNavigationAppBar
import nextstep.shoppingcart.ui.component.ProductCartContent
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var cartItems by remember { mutableStateOf(CartRepository.cartItems) }
    val totalPrice = remember(cartItems) { CartRepository.totalPrice }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackNavigationAppBar(
                title = stringResource(R.string.shopping_cart),
                onBackButtonClick = onBackButtonClick,
            )
        },
        content = { innerPadding ->
            ProductCartContent(
                modifier = Modifier.padding(innerPadding),
                cartItems = cartItems,
                totalPrice = totalPrice,
                onRemoveClick = {
                    cartItems = CartRepository.removeAll(it)
                },
                onIncreaseClick = {
                    cartItems = CartRepository.addOne(it)
                },
                onDecreaseClick = {
                    cartItems = CartRepository.removeOne(it)
                },
            )
        }
    )
}


@Preview
@Composable
private fun ProductCartScreenPreview() {
    ShoppingCartTheme {
        ProductCartScreen(
            onBackButtonClick = {}
        )
    }
}
