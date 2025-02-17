package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopBar(
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.product_list_title),
                fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
            )
        },
        actions = {
            IconButton(onClick = { onCartClick() }) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "cart")
            }
        },
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListTopBarPreview() {
    ProductListTopBar(onCartClick = {})
}
