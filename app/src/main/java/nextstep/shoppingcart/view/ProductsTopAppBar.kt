package nextstep.shoppingcart.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.product_app_bar_title),
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Handle navigation icon click */ }) {

            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle action icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.product_app_bar_cart_icon_description)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProductsTopAppBarPreview() {
    ShoppingCartTheme {
        ProductsTopAppBar()
    }
}
