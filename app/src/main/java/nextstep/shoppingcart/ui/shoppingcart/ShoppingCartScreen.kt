package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ShoppingTopBar

@Composable
fun ShoppingCartScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ShoppingTopBar(
            title = stringResource(id = R.string.shopping_cart_title),
            onBackClick = onBackClick,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onBackClick = {})
}
