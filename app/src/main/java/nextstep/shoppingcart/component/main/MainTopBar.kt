package nextstep.shoppingcart.component.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@Composable
fun MainTopBar(
    onCartClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.product_list),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {},
        actions = {
            IconButton(onClick = onCartClick) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "shopping cart"
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarPreview() {
    MainTopBar(onCartClick = {})
}