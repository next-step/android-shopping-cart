package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.cart.component.CartListItem
import nextstep.shoppingcart.ui.common.component.Button

const val SHOPPING_CART_ORDER_TEST_TAG = "shoppingCartOrder"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(onBack: () -> Unit) {
    var items by remember { mutableStateOf(Cart.items) }
    val totalPrice = remember(items) { Cart.totalPrice }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.shopping_cart)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "backDetail",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(items) { item ->
                    CartListItem(
                        item = item,
                        onClickIncrease = { items = Cart.addOne(item.product) },
                        onClickDecrease = { items = Cart.removeOne(item.product) },
                        onClickCancel = { items = Cart.removeAll(item.product) },
                    )
                }
            }

            Button(
                text = stringResource(id = R.string.order_format, totalPrice),
                onClick = {},
                modifier = Modifier.testTag(SHOPPING_CART_ORDER_TEST_TAG),
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onBack = {})
}
