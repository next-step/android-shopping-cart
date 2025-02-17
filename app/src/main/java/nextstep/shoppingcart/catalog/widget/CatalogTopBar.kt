package nextstep.shoppingcart.catalog.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogTopBar(
    navigateToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(R.string.catalog_top_bar_title),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        actions = {
            IconButton(onClick = { navigateToCart.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = Icons.Filled.ShoppingCart.name,
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun CatalogTopBarPreview() {
    CatalogTopBar(navigateToCart = {})
}