package nextstep.shoppingcart.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.list.model.ProductWithCount
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductList(
    products: List<ProductWithCount>,
    onClickProduct: (id: Int) -> Unit,
    onChangeCount: (id: Int, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = products, key = { it.product.id }) {
            ProductListItem(
                product = it.product,
                modifier = Modifier.clickable {
                    onClickProduct(it.product.id)
                },
                count = it.count,
                onChangeCount = { count -> onChangeCount(it.product.id, count) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    ShoppingCartTheme {
        val items = remember {
            mutableStateOf(
                List(10) {
                    ProductWithCount(
                        product = Product(
                            id = it,
                            imageUrl = "https://picsum.photos/id/1/300/300",
                            name = "PET보틀-정사각형 어쩌구",
                            price = 10000
                        ),
                        count = it
                    )
                }
            )
        }
        ProductList(
            products = items.value,
            onClickProduct = {},
            onChangeCount = { id, count ->
                items.value = items.value.map {
                    if (it.product.id == id) {
                        it.copy(count = count)
                    } else {
                        it
                    }
                }
            }
        )
    }
}
