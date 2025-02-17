package nextstep.shoppingcart.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.detail.widget.DetailContent
import nextstep.shoppingcart.detail.widget.DetailTopBar
import nextstep.shoppingcart.model.Product

@Composable
fun DetailScreen(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { DetailTopBar() }
    ) { paddingValues ->
        DetailContent(
            product = product,
            modifier = Modifier.padding(paddingValues)
        )
    }
}