package nextstep.shoppingcart.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.catalog.widget.CatalogContent
import nextstep.shoppingcart.catalog.widget.CatalogTopBar
import nextstep.shoppingcart.model.Product

val dummyProducts = listOf(
    Product(
        "PET보틀-원형(500ml)",
        42200,
        "https://picsum.photos/id/30/1280/901"
    ),
    Product(
        "PET보틀-원형(500ml)",
        42200,
        "https://picsum.photos/id/30/1280/901"
    ),
    Product(
        "PET보틀-원형(500ml)",
        42200,
        "https://picsum.photos/id/30/1280/901"
    ),
    Product(
        "PET보틀-원형(500ml)",
        42200,
        "https://picsum.photos/id/30/1280/901"
    ),
    Product(
        "PET보틀-원형(500ml)",
        42200,
        "https://picsum.photos/id/30/1280/901"
    ),
)

@Composable
fun CatalogScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { CatalogTopBar() },
    ) { paddingValues ->
        CatalogContent(
            products = dummyProducts,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun CatalogScreenPreview() {
    CatalogScreen()
}