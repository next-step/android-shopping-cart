package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nextstep.shoppingcart.cart.component.CartContent
import nextstep.shoppingcart.cart.model.CartUiState
import nextstep.shoppingcart.cart.model.CartViewModel
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.ProductBackButtonTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    CartScreen(
        uiState = uiState.value,
        onBackButtonClick = onBackButtonClick,
        onAddOneToCart = { product -> viewModel.addOne(product) },
        onRemoveOneFromCart = { product -> viewModel.removeOne(product) },
        onClearCartItem = { product -> viewModel.removeAll(product) },
        onOrderButtonClick = {},
        modifier = modifier
    )
}

@Composable
private fun CartScreen(
    onBackButtonClick: () -> Unit,
    uiState: CartUiState,
    onAddOneToCart: (Product) -> Unit,
    onRemoveOneFromCart: (Product) -> Unit,
    onClearCartItem: (Product) -> Unit,
    onOrderButtonClick: () -> Unit,
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
        CartContent(
            modifier = modifier
                .padding(contentPadding)
                .fillMaxSize(),
            cartItem = uiState.cartItems,
            onAddOneToCart = onAddOneToCart,
            onRemoveOneFromCart = onRemoveOneFromCart,
            onClearCartItem = onClearCartItem,
            totalPrice = uiState.totalPrice,
            onOrderButtonClick = onOrderButtonClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            onBackButtonClick = {},
            viewModel = CartViewModel(repository = Cart),
        )
    }
}
