package nextstep.shoppingcart.ui.productList

import android.content.Intent
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.data.Product
import nextstep.shoppingcart.ui.data.SampleProductList.sampleProductList
import nextstep.shoppingcart.ui.productDetail.ProductDetailActivity
import nextstep.shoppingcart.ui.productList.component.ProductCard
import nextstep.shoppingcart.ui.productList.component.ProductListTopBar
import nextstep.shoppingcart.ui.shoppingCart.ShoppingCartActivity


@Composable
fun ProductListScreen(productList: List<Product>) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            ProductListTopBar(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                onClickCartIcon = {
                    val intent = Intent(context, ShoppingCartActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) {
            ProductLazeColum(productList)
        }
    }
}

@Composable
fun ProductLazeColum(productList: List<Product>) {
    val context = LocalContext.current

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
            ProductCard(
                product = product,
                onClickCard = {
                    val intent = Intent(context, ProductDetailActivity::class.java).apply {
                        putExtra("product", product)
                    }
                    context.startActivity(intent)
                }
            )
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

