package nextstep.shoppingcart.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.detail.widget.DetailContent
import nextstep.shoppingcart.detail.widget.DetailTopBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun DetailScreen(
    product: Product,
    popBackstack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { DetailTopBar(popBackstack) }
    ) { paddingValues ->
        DetailContent(
            product = product,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    ShoppingCartTheme {
        DetailScreen(
            product = Product(
                id = 1,
                name = "상품",
                price = 5000000,
                imageUrl = "https://picsum.photos/id/30/1280/901",
            ),
            popBackstack = {},
        )
    }
}
