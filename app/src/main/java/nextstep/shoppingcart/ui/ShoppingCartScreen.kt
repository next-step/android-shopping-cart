package nextstep.shoppingcart.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ShoppingCartNavigationTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShoppingCartScreen(
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingCartNavigationTopBar(
                title = stringResource(id = R.string.tob_bar_shopping_cart_title),
                onNavigationClick = onNavigationClick
            )
        },
        modifier = modifier.fillMaxSize()
    ) {
    }
}