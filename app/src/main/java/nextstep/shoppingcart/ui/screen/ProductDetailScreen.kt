package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.component.ProductDetailTopBar
import nextstep.shoppingcart.ui.data.Product

@Composable
fun ProductDetailScreen(modifier: Modifier, product: Product) {
    Scaffold(
        topBar = {
            ProductDetailTopBar(modifier)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {

        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        Modifier, Product(
            id = 9170,
            imgUrl = "https://duckduckgo.com/?q=constituto",
            name = "Ernie Santana",
            price = 1590
        )
    )
}