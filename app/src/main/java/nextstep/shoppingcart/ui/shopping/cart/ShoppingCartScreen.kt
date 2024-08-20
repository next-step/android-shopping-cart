package nextstep.shoppingcart.ui.shopping.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.shopping.component.NavTopAppBar


@Composable
fun ShoppingCartScreen(
    onClickNavigateBack: () -> Unit
) {
    val cartItems = Cart.items

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CartTopAppBar(onClickNavigateBack)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                items(cartItems) { item ->
                    CartItemCard(
                        cartItem = item,
                        onClickRemoveItem = {}
                    )
                }
            }
        }
    }
}

@Composable
fun CartTopAppBar(
    onClickNavigateBack: () -> Unit
) {
    NavTopAppBar(
        title = stringResource(id = R.string.shopping_cart),
        onClickNavigateBack = { onClickNavigateBack.invoke() }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPrev() {
    ShoppingCartScreen({})
}

@Preview(showBackground = true)
@Composable
private fun CartTopAppBarPrev() {
    CartTopAppBar(onClickNavigateBack = {})
}
