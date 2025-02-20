package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.ProductItemContainer
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductScreen(
    productList: List<Product>,
    onProductClick: (Product) -> Unit = { },
) {
    ProductListSection(
        products = productList,
        onProductClick = onProductClick
    )
}

@Composable
private fun ProductListSection(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 13.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
    ) {
        items(products) { product ->
            ProductItemContainer(
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