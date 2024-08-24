package nextstep.shoppingcart.ui.screen.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.Product
import nextstep.shoppingcart.ui.screen.cart.Cart
import nextstep.shoppingcart.ui.screen.cart.CartItem
import nextstep.shoppingcart.ui.screen.products.model.ProductModel
import nextstep.shoppingcart.ui.screen.products.model.dummyProductModels
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductRoute(
    onItemClick: (id: String) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var cartItems by remember { mutableStateOf(Cart.items) }
    val onMinusClick = remember { { item: ProductModel -> cartItems = Cart.removeOne(item) } }
    val onPlusClick = remember { { item: ProductModel -> cartItems = Cart.addOne(item) } }
    val onAddClick = remember { { item: ProductModel -> cartItems = Cart.addOne(item) } }

    ProductScreen(
        products = dummyProductModels.toPersistentList(),
        cartItems = cartItems.toPersistentList(),
        onCartClick = onCartClick,
        onItemClick = onItemClick,
        onAddClick = onAddClick,
        onMinusClick = onMinusClick,
        onPlusClick = onPlusClick,
        modifier = modifier
    )
}

@Composable
private fun ProductScreen(
    products: PersistentList<ProductModel>,
    cartItems: PersistentList<CartItem>,
    onItemClick: (id: String) -> Unit,
    onAddClick: (ProductModel) -> Unit,
    onPlusClick: (ProductModel) -> Unit,
    onMinusClick: (ProductModel) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { ProductTopAppBar { onCartClick() } }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                top = 13.dp,
                start = 18.dp,
                end = 18.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            items(
                items = products,
                key = { it.id }
            ) { item ->
                Product(
                    productModel = item,
                    onAddClick = { onAddClick(item) },
                    onPlusClick = { onPlusClick(item) },
                    onMinusClick = { onMinusClick(item) },
                    count = remember { cartItems.find { it.product == item }?.count ?: 0 },
                    modifier = Modifier.clickable { onItemClick(item.id) },
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
            products = dummyProductModels.toPersistentList(),
            cartItems = Cart.items.toPersistentList(),
            onItemClick = { },
            onAddClick = { },
            onPlusClick = { },
            onMinusClick = { },
            onCartClick = { }
        )
    }
}
