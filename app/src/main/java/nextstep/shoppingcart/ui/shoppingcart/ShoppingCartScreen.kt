package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ShoppingButton
import nextstep.shoppingcart.ui.component.ShoppingTopBar
import nextstep.shoppingcart.ui.shoppingcart.component.ShoppingCartLazyColumn

@Composable
fun ShoppingCartScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        ShoppingTopBar(
            title = stringResource(id = R.string.shopping_cart_title),
            onBackClick = onBackClick,
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        ShoppingCartLazyColumn()
        Spacer(modifier = Modifier.weight(weight = 1f))
        ShoppingButton(
            onClick = {},
            buttonTitle = "",
        )
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onBackClick = {})
}
