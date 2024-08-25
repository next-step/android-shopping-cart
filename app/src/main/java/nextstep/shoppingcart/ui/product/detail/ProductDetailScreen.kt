package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: Product
) {
    Row {
        Text(text = product.name)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            name = "aa",
            price = 10000,
            imageUrl = ""
        )
    )
}
