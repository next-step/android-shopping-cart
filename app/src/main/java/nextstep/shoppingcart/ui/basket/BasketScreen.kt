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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.onEach
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun BasketScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    cartRepository: CartRepository = CartRepository.inject(),
) {
    var state by rememberSaveable {
        mutableStateOf(BasketState())
    }

    // Q. 화면이 파괴되면 Composable도 recomposition에서 제외되므로, Fragment에서 처럼 repeatOnLifecycle 등으로 Lifecycle을 지정하지 않아도 되나요?
    LaunchedEffect(Unit) {
        cartRepository.getItems().onEach {
            state = state.copy(cartItems = it)
        }
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
            navigateBack = {
                // no-op. just for preview
            },
        )
    }
}
