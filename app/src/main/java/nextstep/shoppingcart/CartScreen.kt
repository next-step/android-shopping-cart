package nextstep.shoppingcart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.CartItemCard
import nextstep.shoppingcart.model.CartItem

@Composable
internal fun CartScreen(
    cartItems: List<CartItem>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CartTopBar() },
        content = { paddingValues ->
            CartContent(paddingValues, cartItems)
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CartTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.cart_screen_title),
                style = MaterialTheme.typography.titleLarge,
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "ShoppingCart",
                modifier = Modifier
            )
        }
    )
}

@Composable
private fun CartContent(
    paddingValues: PaddingValues,
    cartItems: List<CartItem>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        columns = GridCells.Adaptive(156.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(cartItems) { item ->
            CartItemCard(
                cartItem = item,
            )
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    MaterialTheme {
        CartScreen(
            cartItems = List(20) {
                CartItem(
                    name = "PET보틀 - 정사각형 모양",
                    10000,
                    imageUrl = "https://picsum.photos/500"
                )
            }
        )
    }
}