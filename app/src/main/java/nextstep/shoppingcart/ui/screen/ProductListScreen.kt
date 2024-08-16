package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ProductCard
import nextstep.shoppingcart.ui.data.Product
import nextstep.shoppingcart.ui.data.SampleProductList.sampleProductList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(productList: List<Product>) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_product_list_title),
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = stringResource(id = R.string.text_shopping_cart_Icon_description)
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProductLazeColum(productList)
        }
    }
}

@Composable
fun ProductLazeColum(productList: List<Product>) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState()
    ) {

        items(
            items = productList,
            key = { product ->
                product.id
            }
        ) { product ->
            ProductCard(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(sampleProductList)
}

@Preview(showBackground = true)
@Composable
private fun ProductLazeColumPreview() {
    ProductLazeColum(sampleProductList)
}

