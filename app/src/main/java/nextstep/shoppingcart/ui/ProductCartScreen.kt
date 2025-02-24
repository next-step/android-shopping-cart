package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.component.BackNavigationAppBar
import nextstep.shoppingcart.ui.component.BlueButtonBottomBar
import nextstep.shoppingcart.ui.component.ProductCartList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cart = CartRepository.cartState

    ProductCartScreen(
        modifier = modifier.fillMaxSize(),
        cartItems = cart.items,
        totalPrice = cart.totalPrice,
        orderButtonEnabled = !cart.isEmpty,
        onBackButtonClick = onBackButtonClick,
        onRemoveClick = { CartRepository.removeAll(it) },
        onIncreaseClick = { CartRepository.addOne(it) },
        onDecreaseClick = { CartRepository.removeOne(it) },
        onOrderClick = { /*todo*/ },
    )
}

@Composable
internal fun ProductCartScreen(
    cartItems: List<CartItem>,
    totalPrice: Int,
    orderButtonEnabled: Boolean,
    onBackButtonClick: () -> Unit,
    onRemoveClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    onOrderClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackNavigationAppBar(
                title = stringResource(R.string.shopping_cart),
                onBackButtonClick = onBackButtonClick,
            )
        },
        content = { innerPadding ->
            ProductCartList(
                modifier = Modifier.padding(innerPadding),
                cartItems = cartItems,
                onRemoveClick = onRemoveClick,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
            )
        },
        bottomBar = {
            BlueButtonBottomBar(
                text = stringResource(R.string.cart_total_price_format, totalPrice),
                enabled = orderButtonEnabled,
                onClick = onOrderClick
            )
        }
    )
}

@Preview
@Composable
private fun ProductCartScreenPreview() {
    val cartItems by remember {
        mutableStateOf(
            listOf(
                CartItem(
                    product = ProductRepository.getProductById(1),
                    count = 2,
                ),
            )
        )
    }
    ShoppingCartTheme {
        ProductCartScreen(
            cartItems = cartItems,
            totalPrice = cartItems.sumOf { it.totalPrice },
            orderButtonEnabled = true,
            onBackButtonClick = { },
            onRemoveClick = { },
            onIncreaseClick = { },
            onDecreaseClick = { },
            onOrderClick = { },
        )
    }
}
