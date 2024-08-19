package nextstep.shoppingcart.view

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopAppBar() {
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.cart_app_bar_title))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    val intent = Intent(context, ProductsActivity::class.java)
                    context.startActivity(intent)
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
