package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductsScreen() {
    Scaffold(
        topBar = {
            ProductsTopBar()
        }
    ) { innerPadding ->
        ProductsList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun ProductsTopBar() {

}

@Composable
private fun ProductsList(
    modifier: Modifier = Modifier
) {

}

@Composable
private fun ProductsItem() {

}