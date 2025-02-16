package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.ui.component.ProductList
import nextstep.shoppingcart.ui.component.ProductListTopBar

@Composable
fun ProductListScreen() {
    Scaffold(
        topBar = {
            ProductListTopBar(
                onCartClick = {},
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        ProductList(
            modifier = Modifier.padding(paddingValues)
        )
    }
}