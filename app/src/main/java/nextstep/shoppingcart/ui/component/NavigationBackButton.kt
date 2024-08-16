package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun NavigationBackButton(navigateUp: () -> Unit = {}) {
    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.navigate_back),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NavigationBackButtonPreview() {
    ShoppingCartTheme {
        NavigationBackButton()
    }
}
