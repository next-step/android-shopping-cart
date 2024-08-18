package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.model.dummyProducts
import nextstep.shoppingcart.ui.product.list.component.ProductListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list)) },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .size(48.dp),
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
            ProductListContent(products = dummyProducts)
        }
    }
}

@Composable
private fun ProductListContent(
    products: List<Product>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = modifier,
    ) {
        items(products) {
            ProductListItem(
                item = it,
                onClick = { }, // todo: need to implement
            )
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen()
}
