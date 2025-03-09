package nextstep.shoppingcart.cart

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.common.component.BackTitleAppBar
import nextstep.shoppingcart.common.component.BottomButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    totalPrice: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackTitleAppBar(
                title = stringResource(R.string.cart),
                onBack = onBack
            )
        },
        bottomBar = {
            BottomButton(
                label = stringResource(R.string.order_price_format, totalPrice),
                onClick = {}
            )
        }
    ) { _ ->

    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            onBack = {},
            cartItems = emptyList(),
            totalPrice = 100000,
        )
    }
}
