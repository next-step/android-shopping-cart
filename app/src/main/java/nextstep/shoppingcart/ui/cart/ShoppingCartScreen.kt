package nextstep.shoppingcart.ui.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.component.ShoppingCartButton
import nextstep.shoppingcart.ui.component.ShoppingCartNavigationTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartScreen(
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var cartItems by remember {
        mutableStateOf(Cart.items)
    }

    val totalPrice by remember(cartItems) {
        derivedStateOf {
            cartItems.sumOf { it.totalPrice }
        }
    }

    Scaffold(
        topBar = {
            ShoppingCartNavigationTopBar(
                title = stringResource(id = R.string.tob_bar_shopping_cart_title),
                onNavigationClick = onNavigationClick
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(
                        top = innerPadding.calculateTopPadding(),
                        start = 18.dp,
                        end = 18.dp
                    )

            ) {
                items(cartItems) { cartItem ->
                    CartInfo(
                        cartItem = cartItem,
                        onRemoveClick = {
                            cartItems = Cart.removeAll(cartItem.product)
                        },
                        onMinusClick = {
                            cartItems = Cart.removeOne(cartItem.product)
                        },
                        onPlusClick = {
                            cartItems = Cart.addOne(cartItem.product)
                        }
                    )
                }
            }

            ShoppingCartButton(
                onClick = { /*TODO*/ },
                buttonText = stringResource(id = R.string.total_price_title, totalPrice),
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen(
            onNavigationClick = { /*TODO*/ }
        )
    }
}