package nextstep.shoppingcart.features.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.MainButton
import nextstep.shoppingcart.components.topbars.StartTitleTopBar
import nextstep.shoppingcart.components.topbars.TopBarNavigationType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.features.cart.components.CartList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun CartScreen(
    cart: Cart,
    onAddOneClick: (Product) -> Unit,
    onRemoveOneClick: (Product) -> Unit,
    onRemoveAllClick: (Product) -> Unit,
    onBackClick: () -> Unit,
) {
    val totalPrice: Int = cart.totalPrice

    Scaffold(
        topBar = {
            StartTitleTopBar(
                title = stringResource(R.string.cart_top_bar_title),
                navigationType = TopBarNavigationType.BACK,
                onNavigationClick = onBackClick,
            )
        },
        containerColor = Color.White,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            CartList(
                cart = cart,
                onAddOneClick = onAddOneClick,
                onRemoveOneClick = onRemoveOneClick,
                onRemoveAllClick = onRemoveAllClick,
                modifier = Modifier.weight(1f)
            )
            MainButton(
                text = stringResource(R.string.cart_item_order_button_text_format, totalPrice),
                onClick = {},
                enabled = totalPrice > 0,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
            )
        }
    }
}


@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            cart = Cart(
                initialItems = FakeProductRepository
                    .getAllProducts()
                    .value
                    .map { CartItem(it) }
            ),
            onBackClick = {},
            onAddOneClick = {},
            onRemoveOneClick = {},
            onRemoveAllClick = {},
        )
    }
}
