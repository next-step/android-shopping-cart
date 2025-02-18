package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.ProductItem
import nextstep.shoppingcart.ui.screen.component.CenterAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductScreen(
    onProductClick: (Product) -> Unit = { },
    productList: List<Product>,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            ProductListSection(
                products = productList,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
fun ProductListSection(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onProductClick: (Product) -> Unit,
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
        items(products) { product ->
            ProductItem(
                imageUrl = product.imageUrl,
                title = product.title,
                price = product.price,
                modifier = Modifier.clickable(
                    onClick = { onProductClick(product) }
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppbarPreview() {
    CenterAppBar(
        title = "상품 목록",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        imageUrl = "https://www.picsum.photos/200",
        title = "상품 이름",
        price = 10000,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val fakeItemList = FakeData.products
    ProductListSection(
        products = fakeItemList,
        onProductClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductScreen(
            productList = FakeData.products
        )
    }
}