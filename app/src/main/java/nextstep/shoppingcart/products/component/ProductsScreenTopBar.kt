package nextstep.shoppingcart.products.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreenTopBar(
    onCartIconClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(R.string.products_screen_top_bar_title)) },
        actions = {
            IconButton(
                onClick = onCartIconClick,
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = stringResource(
                        R.string.products_screen_top_bar_button_cart_content_description
                    ),
                )
            }
        }
    )
}
