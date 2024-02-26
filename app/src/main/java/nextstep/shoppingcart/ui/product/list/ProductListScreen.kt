package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import nextstep.shoppingcart.data.CartRepository
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.product.list.component.ProductItem

@Composable
internal fun ProductListScreen(
    onCartClick: () -> Unit,
    onProductItemClick: (Product) -> Unit,
) {
    var cart by remember {
        mutableStateOf(CartRepository.getCart())
    }
    ProductListScreen(
        cart = cart,
        products = Products,
        onCartClick = onCartClick,
        onProductAddClick = {
            cart = CartRepository.addToCart(it)
        },
        onProductMinusClick = {
            cart = CartRepository.removeFromCart(it)
        },
        onProductItemClick = onProductItemClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    cart: Cart,
    products: List<Product>,
    onCartClick: () -> Unit,
    onProductAddClick: (Product) -> Unit,
    onProductMinusClick: (Product) -> Unit,
    onProductItemClick: (Product) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list_title)) },
                actions = {
                    IconButton(onClick = onCartClick) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "장바구니",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .testTag("products"),
            ) {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        count = cart.findItemByProductId(product.id)?.count ?: 0,
                        onAddClick = { onProductAddClick(product) },
                        onMinusClick = { onProductMinusClick(product) },
                        onItemClick = { onProductItemClick(product) },
                        modifier = Modifier.testTag(product.id)
                    )
                }
            }
        },
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(
            cart = Cart(emptyList()),
            products = Products,
            onCartClick = {},
            onProductAddClick = {},
            onProductMinusClick = {},
            onProductItemClick = {},
        )
    }
}
