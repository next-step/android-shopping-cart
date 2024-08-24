package nextstep.shoppingcart.view.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.Blue50
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onBack: () -> Unit,
    onOrderClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            CartTopAppBar(onBack = onBack)
        },
        bottomBar = {
            CartButton(
                onButtonClick = onOrderClicked,
                text = stringResource(id = R.string.cart_button, Cart.totalPrice),
                fontSize = dimensionResource(id = R.dimen.product_detail_button_text_size).value.sp,
                color = ButtonDefaults.buttonColors(Blue50),
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            CartList(
                cartItems = cartItems,
                contentPadding = PaddingValues(
                    horizontal = 18.dp,
                    vertical = 16.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            listOf(
                CartItem(dummyProducts[0], 1),
                CartItem(dummyProducts[1], 1),
                CartItem(dummyProducts[2], 1),
                CartItem(dummyProducts[3], 1),
                CartItem(dummyProducts[4], 1),
            ),
            onBack = {},
            onOrderClicked = {})
    }
}
