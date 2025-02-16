package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.BackNavigationAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackNavigationAppBar(
                title = stringResource(R.string.shopping_cart),
                onBackButtonClick = onBackButtonClick,
            )
        },
        content = { _ -> }
    )
}


@Preview
@Composable
private fun ProductCartScreenPreview() {
    ShoppingCartTheme {
        ProductCartScreen(
            onBackButtonClick = {}
        )
    }
}
