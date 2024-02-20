package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.ui.cart.component.CartItemList

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
        OrderButton(
            totalPrice = uiState.totalPrice,
            onClick = onOrderClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun OrderButton(
    totalPrice: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(Color(0xFF2196F3))
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = R.string.cart_order_fmt, totalPrice),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.White,
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
