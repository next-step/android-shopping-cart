package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.product_list),
                style = MaterialTheme.typography.titleLarge.copy(color = Color(0xFF1D1B20))
            )
        },
        actions = {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = onClickButton
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = null,
                )
            }
        }
    )
}

@Preview
@Composable
private fun ProductListTopAppBarPreview() {
    ProductListTopAppBar {}
}
