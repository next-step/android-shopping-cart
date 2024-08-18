package nextstep.shoppingcart.ui.shoppingCart

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.shoppingCart.component.ShoppingCartTopBar

@Composable
fun ShoppingCardScreen(modifier: Modifier) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            ShoppingCartTopBar(modifier, onClickBackIcon = { (context as? Activity)?.finish() })
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) {

        }
    }
}

@Preview
@Composable
private fun ShoppingCardScreenPreview() {
    ShoppingCardScreen(Modifier)
}