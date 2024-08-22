package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.product.list.component.ProductListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    onShowShoppingCart: () -> Unit,
    onShowProductDetail: (Product) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list)) },
                actions = {
                    IconButton(
                        onClick = onShowShoppingCart,
                        modifier = Modifier,
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "shoppingCartIcon",
                            tint = Color.Black,
                            modifier = Modifier,
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            ProductListContent(
                products = dummyProducts,
                cartItems = Cart.items.toList(),
                onClickItem = { onShowProductDetail(it) },
                onClickCountIncrease = { Cart.addOne(it) },
                onClickCountDecrease = { Cart.removeOne(it) },
            )
        }
    }
}

@Composable
private fun ProductListContent(
    products: List<Product>,
    cartItems: List<CartItem>,
    onClickItem: (Product) -> Unit,
    onClickCountIncrease: (Product) -> Unit,
    onClickCountDecrease: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = modifier,
    ) {
        items(products) { product ->
            ProductListItem(
                item = product,
                count = cartItems.find { it.product == product }?.count ?: 0,
                onClick = onClickItem,
                onClickCountIncrease = { onClickCountIncrease(product) },
                onClickCountDecrease = { onClickCountDecrease(product) },
            )
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(onShowShoppingCart = {}, onShowProductDetail = {})
}
