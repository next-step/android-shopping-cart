package nextstep.shoppingcart.ui.screen.products

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.CartItem
import nextstep.shoppingcart.ui.screen.products.model.Product
import nextstep.shoppingcart.ui.screen.products.model.dummyProducts
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductRoute(
    modifier: Modifier = Modifier
) {
    ProductScreen(
        cartItems = dummyProducts.toPersistentList(),
        modifier = modifier
    )
}

@Composable
private fun ProductScreen(
    cartItems: PersistentList<Product>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { ProductTopAppBar { /* TODO */ } }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 18.dp,
                end = 17.dp,
                top = 13.dp
            )
        ) {
            items(cartItems) { item ->
                CartItem(
                    product = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ProductTopAppBar(
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.products_app_bar_title),
                style = MaterialTheme.typography.titleLarge
            )
        }, actions = {
            IconButton(
                onClick = { onActionClick() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.products_app_bar_action_description)
                )
            }
        }
    )
}

@Preview
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductScreen(
            cartItems = dummyProducts.toPersistentList(),
        )
    }
}
