package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Cart

@Composable
fun ShoppingCartScreen(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var cartItemList by remember { mutableStateOf(Cart.items) }
    val totalAmount by remember(cartItemList) { mutableIntStateOf(Cart.totalPrice) }

    ShoppingCartScreen(
        cartItemList = cartItemList,
        totalAmount = totalAmount,
        onPlusClick = { cartItem ->
            cartItemList = Cart.addOne(product = cartItem.product)
        },
        onMinusClick = { cartItem ->
            cartItemList = Cart.removeOne(product = cartItem.product)
        },
        onCloseClick = { cartItem ->
            cartItemList =  Cart.removeAll(product = cartItem.product)
        },
        onBackClick = onClickBack,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    cartItemList: List<CartItem>,
    totalAmount: Int,
    onPlusClick : (CartItem) -> Unit,
    onMinusClick : (CartItem) -> Unit,
    onCloseClick : (CartItem) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBarWithBack(
                title = stringResource(id = R.string.shopping_cart_title),
                onClickBack = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CartList(
                modifier = Modifier
                    .weight(1f),
                cartItemList = cartItemList,
                onPlusClick = onPlusClick,
                onMinusClick = onMinusClick,
                onCloseClick = onCloseClick
            )
            ShoppingTextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                },
                text = stringResource(id = R.string.shopping_cart_order_button, totalAmount)
            )
        }
    }
}

@Composable
fun ColumnScope.CartList(
    cartItemList: List<CartItem>,
    onPlusClick : (CartItem) -> Unit,
    onMinusClick : (CartItem) -> Unit,
    onCloseClick : (CartItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 18.dp,
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(cartItemList) { cartItem ->
            CartItemComponent(
                cartItem = cartItem,
                onPlusClick = {
                    if (cartItem.count < 99) { // 최대 99개로 설정
                        onPlusClick(cartItem)
                    }
                },
                onMinusClick = {
                    onMinusClick(cartItem)
                },
                onCloseClick = {
                    onCloseClick(cartItem)
                }
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