package nextstep.shoppingcart.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartAppBar(
    title: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        ) },
        navigationIcon = {
            IconButton(
                onClick = onBackPressed
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    )
}

@Preview
@Composable
private fun ShoppingCartAppBarPreview() {
    ShoppingCartTheme {
        ShoppingCartAppBar(
            title = stringResource(R.string.product_detail),
            onBackPressed = {}
        )
    }
}