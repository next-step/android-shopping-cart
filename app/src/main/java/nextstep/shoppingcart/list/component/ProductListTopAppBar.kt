package nextstep.shoppingcart.list.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(
    title: String,
    navigateToCart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1D1B20)
            )
        },
        actions = {
            IconButton(
                onClick = navigateToCart
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.cart),
                    tint = Color.Black
                )
            }
        }
    )
}

@Preview
@Composable
private fun ProductListTopAppBarPreview() {
    ShoppingCartTheme {
        ProductListTopAppBar(
            title = "상품 목록",
            navigateToCart = {}
        )
    }
}
