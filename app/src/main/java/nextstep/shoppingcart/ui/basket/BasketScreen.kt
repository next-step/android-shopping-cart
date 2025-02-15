@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun BasketScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val state by rememberSaveable {
        mutableStateOf(BasketState())
    }

    BasketScreen(
        state = state,
        navigateBack = navigateBack,
        modifier = modifier,
    )
}

@Composable
private fun BasketScreen(
    state: BasketState,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            BasketTopBar(navigateBack)
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }
    }
}

@Composable
private fun BasketTopBar(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(stringResource(R.string.basket))
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack,
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigation_back),
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
            containerColor = Color.White,
        )
    )
}

@Preview
@Composable
private fun BasketScreenPreview() {
    ShoppingCartTheme {
        BasketScreen(
            state = BasketState(),
            navigateBack = {},
        )
    }
}
