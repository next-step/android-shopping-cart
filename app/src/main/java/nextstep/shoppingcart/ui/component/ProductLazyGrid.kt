package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.White

@Composable
fun ProductLazyGrid(
    products: List<Product>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.background(White),
        contentPadding = PaddingValues(
            horizontal = 18.dp,
            vertical = 13.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) { item ->
            ProductItem(
                product = item,
                onClick = onClick,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductLazyGridPreview() {
    val products: List<Product> = List(20) { _ ->
        Product(
            imageUrl = "https://picsum.photos/600/600",
            name = "상품명",
            price = 10000
        )
    }

    ProductLazyGrid(
        products = products,
        onClick = {}
    )
}