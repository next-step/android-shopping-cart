package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.ProductItem
import nextstep.shoppingcart.ui.screen.component.TopAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                onClick = {}
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val fakeItemList = FakeData.products
            Column {
                ProductListSection(products = fakeItemList)
            }
        }
    }
}

@Composable
fun ProductListSection(
    modifier: Modifier = Modifier,
    products: List<Product>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 13.dp),
    ) {
        items(products.size) { index ->
            ProductItem(
                imageUrl = products[index].imageUrl,
                title = products[index].title,
                price = products[index].price
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppbarPreview() {
    TopAppBar {}
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        imageUrl = "https://www.picsum.photos/200",
        title = "상품 이름",
        price = 10000
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val fakeItemList = FakeData.products
    ProductListSection(
        products = fakeItemList
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductScreen()
    }
}