package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.EerieBlack
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListTopAppBar(
    modifier: Modifier = Modifier,
    onShoppingCartClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                modifier = modifier,
                maxLines = 1,
                text = stringResource(R.string.shopping_list),
                style = MaterialTheme.typography.titleLarge
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = EerieBlack,
        ),
        actions = {
            IconButton(onClick = onShoppingCartClick) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.shopping_cart),
                    tint = EerieBlack
                )
            }
        }
    )
}

@Preview
@Composable
private fun ShoppingListTopAppBarPreview() {
    ShoppingCartTheme {
        ShoppingListTopAppBar()
    }
}
