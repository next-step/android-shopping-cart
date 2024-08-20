package nextstep.shoppingcart.ui.product.list

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
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.PRODUCT_LIST_MOCK_DATA
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.data.ProductsImpl
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.BasicIconButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductListRoute(
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit = {},
    onProductDetailClick: (Long) -> Unit = {},
) {
    val products: Products = remember { ProductsImpl() }
    var carts by remember { mutableStateOf(Cart.items) }
    val eventListener =
        remember {
            { event: ProductListEvent ->
                when (event) {
                    is ProductListEvent.OnProductCardClick -> {
                        onProductDetailClick(event.productId)
                    }

                    is ProductListEvent.OnCartClick -> {
                        onCartClick()
                    }

                    is ProductListEvent.OnAddToCartClick -> {
                        carts = Cart.add(event.product)
                    }

                    is ProductListEvent.OnAddQuantityClick -> {
                        carts = Cart.add(event.product)
                    }

                    is ProductListEvent.OnRemoveQuantityClick -> {
                        carts = Cart.remove(event.product)
                    }
                }
            }
        }

    ProductListScreen(
        items = products.getAll(),
        carts = carts,
        onProductListEvent = eventListener,
        modifier = modifier.fillMaxSize(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    items: List<Product>,
    carts: List<CartItem>,
    onProductListEvent: (ProductListEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.product_list_toolbar_title))
                },
                actions = {
                    BasicIconButton(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription =
                            stringResource(
                                id = R.string.shopping_card_content_description,
                            ),
                        onClick = { onProductListEvent(ProductListEvent.OnCartClick) },
                    )
                },
            )
        },
        modifier = modifier,
    ) { innerPadding ->
        ProductListContent(
            items = items,
            carts = carts,
            onProductListEvent = onProductListEvent,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
private fun ProductListContent(
    items: List<Product>,
    carts: List<CartItem>,
    onProductListEvent: (ProductListEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding =
            PaddingValues(
                start = 18.dp,
                end = 18.dp,
                top = 13.dp,
            ),
        modifier = modifier,
    ) {
        items(
            items = items,
            key = { item -> item.id },
        ) { item ->
            ProductCard(
                product = item,
                quantity = carts.find { it.product.id == item.id }?.quantity ?: 0,
                onCardClick = {
                    onProductListEvent(
                        ProductListEvent.OnProductCardClick(productId = item.id),
                    )
                },
                onAddToCartClick = {
                    onProductListEvent(
                        ProductListEvent.OnAddToCartClick(product = item),
                    )
                },
                onAddQuantityClick = {
                    onProductListEvent(
                        ProductListEvent.OnAddQuantityClick(product = item),
                    )
                },
                onRemoveQuantityClick = {
                    onProductListEvent(
                        ProductListEvent.OnRemoveQuantityClick(product = item),
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            items = PRODUCT_LIST_MOCK_DATA,
            carts =
                PRODUCT_LIST_MOCK_DATA.mapIndexed { index, product ->
                    CartItem(
                        product = product,
                        quantity = if (index % 2 == 0) 1 else 0,
                    )
                },
            onProductListEvent = {},
        )
    }
}
