package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productDetail.ProductDetailActivity

@Composable
fun ProductList(
    products: List<Product> = emptyList(),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
        items(products.size) { index ->
            ProductItem(
                product = products[index],
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    ProductDetailActivity.start(context, products[index])
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val products = List(10) {
        Product(
            "상품이름",
            "",
            10_000
        )
    }

    ProductList(
        products = products
    )
}