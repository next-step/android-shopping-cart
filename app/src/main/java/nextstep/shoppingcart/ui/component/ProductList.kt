package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.CartRepository

@Composable
internal fun ProductList(
    productList: List<Product>,
    cart: Cart,
    modifier: Modifier = Modifier,
    onIncreaseClick: (Product) -> Unit = {},
    onDecreaseClick: (Product) -> Unit = {},
    onProductClick: (Product) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 13.dp, start = 18.dp, end = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(
            items = productList,
            key = { it.id }
        ) { product ->
            ProductItem(
                product = product,
                count = cart.getCountByProductId(product.id),
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
                onProductClick = onProductClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListContentPreview() {
    ProductList(
        productList = (0..100).map {
            Product(
                id = it,
                imageUrl = "https://www.google.com/#q=tristique",
                name = "상품_$it",
                price = 3124
            )
        },
        cart = CartRepository.cartState,
    )
}
