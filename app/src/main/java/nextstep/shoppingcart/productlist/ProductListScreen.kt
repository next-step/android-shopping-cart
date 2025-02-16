package nextstep.shoppingcart.productlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    productList: List<Product>,
    onProductClick: (id: String) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { ProductListAppBar(onCartClick = onCartClick) }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productList, key = { it.id }) {
                ProductItem(product = it, onClick = { onProductClick(it.id) })
            }
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            productList = products,
            onProductClick = {},
            onCartClick = {}
        )
    }
}