package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.CartItemComponent
import nextstep.shoppingcart.component.ShoppingTextButton
import nextstep.shoppingcart.component.topbar.ShoppingTopBarWithBack
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Cart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cartItemList by remember(Cart.items) {
        mutableStateOf(Cart.items)
    }
    val totalAmount by remember(Cart.totalPrice) {
        mutableIntStateOf(Cart.totalPrice)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBarWithBack(
                title = stringResource(id = R.string.shopping_cart_title),
                onClickBack = onClickBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                contentPadding = PaddingValues(
                    horizontal = 18.dp,
                    vertical = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(cartItemList){ cartItem ->
                    CartItemComponent(
                        cartItem = cartItem,
                        onClickPlus = {

                        },
                        onClickMinus = {

                        },
                        onClickClose = {

                        }
                    )
                }
            }
            ShoppingTextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                },
                text = stringResource(id = R.string.shopping_cart_order_button,totalAmount)
            )
        }
    }
}

@Preview(name = "ShoppingCartScreen")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingCartScreen(
            onClickBack = {}
        )
    }
}