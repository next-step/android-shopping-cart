package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.AppBarIcon

@Composable
internal fun CartRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit = {},
) {
    CartScreen(
        navigateUp = onNavigateUp,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.cart_toolbar_title))
                },
                navigationIcon = {
                    AppBarIcon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigate_back),
                        onClick = navigateUp,
                    )
                },
            )
        },
        modifier = modifier,
    ) { paddingValues ->
        CartContent(
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
private fun CartContent(modifier: Modifier = Modifier) {
}
