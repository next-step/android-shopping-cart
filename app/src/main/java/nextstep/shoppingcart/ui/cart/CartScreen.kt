package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.ui.cart.component.CartItemList
import nextstep.shoppingcart.ui.component.CartButton

@Composable
internal fun CartScreen(onBackClick: () -> Unit) {
    var uiState by remember {
        val uiState = CartUiState(
            items = Products.map {
                CartItemUiState(product = it, count = 1)
            }
        )
        mutableStateOf(uiState)
    }

    CartScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onCartDeleteClick = { item ->
            uiState = uiState.copy(
                items = uiState.items.filter { it.product.id != item.product.id }
            )
        },
        onCartPlusClick = { item ->
            val nextItems = uiState.items.map {
                if (it.product.id == item.product.id) {
                    it.copy(count = it.count + 1)
                } else {
                    it
                }
            }
            uiState = uiState.copy(items = nextItems)
        },
        onCartMinusClick = { item ->
            val nextItems = uiState.items.map {
                if (it.product.id == item.product.id) {
                    it.copy(count = (it.count - 1).coerceAtLeast(1))
                } else {
                    it
                }
            }
            uiState = uiState.copy(items = nextItems)
        },
        onOrderClick = { /*TODO*/ })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    uiState: CartUiState,
    onBackClick: () -> Unit,
    onCartDeleteClick: (CartItemUiState) -> Unit,
    onCartPlusClick: (CartItemUiState) -> Unit,
    onCartMinusClick: (CartItemUiState) -> Unit,
    onOrderClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.cart_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            CartContent(
                uiState = uiState,
                onCartDeleteClick = onCartDeleteClick,
                onCartPlusClick = onCartPlusClick,
                onCartMinusClick = onCartMinusClick,
                onOrderClick = onOrderClick,
                modifier = Modifier.padding(innerPadding),
            )
        },
    )
}

@Composable
private fun CartContent(
    uiState: CartUiState,
    onCartDeleteClick: (CartItemUiState) -> Unit,
    onCartPlusClick: (CartItemUiState) -> Unit,
    onCartMinusClick: (CartItemUiState) -> Unit,
    onOrderClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        CartItemList(
            items = uiState.items,
            onDeleteClick = onCartDeleteClick,
            onPlusClick = onCartPlusClick,
            onMinusClick = onCartMinusClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        CartButton(
            text = stringResource(id = R.string.cart_order_fmt, uiState.totalPrice),
            onClick = onOrderClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    MaterialTheme {
        CartScreen(
            onBackClick = { },
        )
    }
}
