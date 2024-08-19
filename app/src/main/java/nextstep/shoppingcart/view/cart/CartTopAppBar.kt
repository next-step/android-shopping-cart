package nextstep.shoppingcart.view.cart

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopAppBar() {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.cart_app_bar_title))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onBackPressedDispatcher?.onBackPressed()
                }
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.cart_app_bar_back_icon_description)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun CartTopAppBarPreview() {
    ShoppingCartTheme {
        CartTopAppBar()
    }
}
