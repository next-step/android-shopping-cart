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
import nextstep.shoppingcart.R.string.shopping_cart_title
import nextstep.shoppingcart.R.string.shopping_cart_total_format
import nextstep.shoppingcart.data.Cart.addOne
import nextstep.shoppingcart.data.Cart.findProductById
import nextstep.shoppingcart.data.Cart.items
import nextstep.shoppingcart.data.Cart.removeAll
import nextstep.shoppingcart.data.Cart.totalPrice
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
            title = stringResource(id = shopping_cart_title),
            onBackClick = onBackClick,
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        ShoppingCartLazyColumn(
            cartProducts = items,
            onRemoveClick = { cartProductId -> removeAll(findProductById(cartProductId)) },
            onSubtractClick = { cartProductId -> addOne(findProductById(cartProductId)) },
            onAddClick = { cartProductId -> addOne(findProductById(cartProductId)) },
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        ShoppingButton(
            onClick = {},
            buttonTitle = stringResource(id = shopping_cart_total_format, totalPrice),
        )
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onBackClick = {})
}
