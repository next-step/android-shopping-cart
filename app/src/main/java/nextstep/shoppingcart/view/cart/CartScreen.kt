package nextstep.shoppingcart.view.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.view.resource.Blue50
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onBack: () -> Unit,
    onOrderClicked: () -> Unit,
) {
    var totalPrice by remember { mutableIntStateOf(Cart.totalPrice) }

    fun handleItemRemoved(item: CartItem) {
        Cart.removeAll(item.product)
        totalPrice = Cart.totalPrice
    }

    fun handleAddClicked(item: CartItem) {
        Cart.addOne(item.product)
        totalPrice = Cart.totalPrice
    }

    fun handleRemoveClicked(item: CartItem) {
        Cart.removeOne(item.product)
        totalPrice = Cart.totalPrice
    }

    Scaffold(
        topBar = {
            CartTopAppBar(onBack = onBack)
        },
        bottomBar = {
            CartButton(
                onButtonClick = onOrderClicked,
                text = stringResource(id = R.string.cart_button, totalPrice),
                fontSize = dimensionResource(id = R.dimen.product_detail_button_text_size).value.sp,
                color = ButtonDefaults.buttonColors(Blue50),
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            CartList(
                cartItems = cartItems,
                contentPadding = PaddingValues(
                    horizontal = dimensionResource(id = R.dimen.cart_screen_list_padding_horizontal),
                    vertical = dimensionResource(id = R.dimen.cart_screen_list_padding_vertical),
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                onItemRemoved = ::handleItemRemoved,
                onAddClicked = ::handleAddClicked,
                onRemoveClicked = ::handleRemoveClicked,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            cartItems = Cart.items,
            onBack = {},
            onOrderClicked = {},
        )
    }
}
