package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@Composable
fun ShoppingCartRoute(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    ShoppingCartScreen(
        modifier = modifier,
        onNavigationClick = onNavigationClick
    )
}

@Composable
private fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartTopAppBar(onNavigationClick = onNavigationClick)
        }
    ) {
        // TODO
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShoppingCartTopAppBar(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.shopping_cart_app_bar_title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button_navigation_icon_description)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(onNavigationClick = {})
}
