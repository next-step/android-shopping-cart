package nextstep.shoppingcart.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.catalog.widget.CatalogContent
import nextstep.shoppingcart.catalog.widget.CatalogTopBar

@Composable
fun CatalogScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { CatalogTopBar() },
    ) { paddingValues ->
        CatalogContent(modifier = Modifier.padding(paddingValues))
    }
}

@Preview
@Composable
private fun CatalogScreenPreview() {
    CatalogScreen()
}