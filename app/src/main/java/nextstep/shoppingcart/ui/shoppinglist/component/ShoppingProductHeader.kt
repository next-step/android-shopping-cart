package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.ui.component.ShoppingCountBar
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingProductHeader(
    product: Product,
    onPutClick: (productId: Long) -> Unit,
    onAddClick: (productId: Long) -> Unit,
    onSubtractClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
    ) {
        ShoppingProductImage(
            product = product,
            modifier = modifier
                .size(size = 156.dp)
                .background(Color.Black),
        )
        when (product.containedCount > 0) {
            true -> ShoppingCountBar(
                count = product.containedCount,
                onSubtractClick = { onSubtractClick(product.id) },
                onAddClick = { onAddClick(product.id) },
                modifier = Modifier.align(Alignment.BottomCenter),
            )

            false -> ShoppingProductAddButton(
                onAddButton = { onPutClick(product.id) },
                modifier = Modifier.padding(12.dp),
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingProductHeaderPreview() {
    ShoppingProductHeader(
        product = dummyProducts[0].copy(containedCount = 2),
        onPutClick = {},
        onAddClick = {},
        onSubtractClick = {},
    )
}
