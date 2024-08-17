package nextstep.shoppingcart.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.topbar.ShoppingTopBarWithBack
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBarWithBack(
                title = stringResource(id = R.string.shopping_cart_title),
                onClickBack = {

                }
            )
        }
    ) { innerPadding ->

    }
}

@Preview(name = "ShoppingCartScreen")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingCartScreen()
    }
}