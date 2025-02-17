package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.common.CommonTopAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.shopping_cart_app_bar_title),
                onBackButtonClick = onBackButtonClick
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen(onBackButtonClick = {})
    }
}

