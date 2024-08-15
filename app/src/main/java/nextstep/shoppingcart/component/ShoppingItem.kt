package nextstep.shoppingcart.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import nextstep.shoppingcart.model.Product

const val SHOPPING_ITEM_WIDTH = 156

@Composable
fun LazyGridItemScope.ShoppingItem(
    product: Product,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun LazyGridItemScope.PreviewShoppingItem() {
    ShoppingItem(
        product = Product(
            imageUrl = "https://picsum.photos/id/0/5000/3333",
            name = "신형 노트북",
            price = 2_000_000
        ),
        onClick = {

        }
    )
}