package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.BasicTopBar

@Composable
fun ShoppingCardScreen(modifier: Modifier) {
    Scaffold(
        topBar = {
            BasicTopBar(modifier, R.string.text_shopping_cart_title)
        }
    ) { innerPading ->
        Column(
            modifier = Modifier.padding(innerPading)
        ) {

        }
    }
}

@Preview
@Composable
private fun ShoppingCardScreenPreview() {
    ShoppingCardScreen(Modifier)
}