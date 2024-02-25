package nextstep.shoppingcart.ui.feature

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.Product
import nextstep.shoppingcart.ui.feature.component.PriceText

@Composable
fun ProductListScreenRouter(
    onProductClick: (Int) -> Unit,
    onCartClick: () -> Unit,
) {
    ProductListScreen(
        products = Products,
        onProductClick = onProductClick,
        onCartClick = onCartClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list_title)) },
                actions = {
                    IconButton(onClick = { onCartClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(id = R.string.cart)
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        ProductList(
            products = products,
            onProductClick = onProductClick,
            onAddCartClick = {},
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun ProductList(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    onAddCartClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = PaddingValues(18.dp),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items = products) {
            ProductItem(it, onProductClick = onProductClick, onAddCartClick = onAddCartClick)
        }
    }

}

@Composable
private fun ProductItem(
    product: Product,
    onProductClick: (Int) -> Unit,
    onAddCartClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable { onProductClick(product.id) }) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f),
                model = product.imageUrl,
                contentDescription = stringResource(id = R.string.product_image),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { onAddCartClick(product.id) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .size(42.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.product_list_add_cart)
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            text = product.name,
            maxLines = 1
        )
        PriceText(
            modifier = Modifier.padding(start = 4.dp),
            price = product.price
        )
    }

}


@Preview(showBackground = true, widthDp = 156)
@Composable
private fun ProductItemPreview() {
    ProductItem(Products.first(), {}, {})
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(Products, {}, {})
}
