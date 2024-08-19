package nextstep.shoppingcart.productlist

import androidx.compose.foundation.clickable
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
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ProductCard
import nextstep.shoppingcart.model.Product
import java.util.UUID

@Composable
internal fun ProductListScreen(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProductListTopBar() },
        content = { paddingValues ->
            ProductListContent(
                paddingValues, products, onProductClick
            )
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductListTopBar() {
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
private fun ProductListContent(
    paddingValues: PaddingValues,
    products: List<Product>,
    onProductClick: (Product) -> Unit,
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
        items(
            items = products,
            key = { item -> item.id }
        ) { item ->
            ProductCard(
                product = item,
                modifier = Modifier.clickable { onProductClick(item) }
            )
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(
            products = List(20) {
                Product(
                    id = UUID.randomUUID().toString(),
                    name = "PET보틀 - 정사각형 모양",
                    10000,
                    imageUrl = "https://picsum.photos/500"
                )
            }.distinctBy { it.id },
            onProductClick = {},
        )
    }
}