package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.data.Product

@Composable
fun ProductDetailScreen(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column {
        Text("${product.title}", modifier = modifier)
    }
}