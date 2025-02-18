package nextstep.shoppingcart.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(modifier: Modifier = Modifier) {
    Text("ProductDetailScreen")
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen()
    }
}
