@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.product_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier
) {
    val state by remember {
        mutableStateOf(ProductListState())
    }

    ProductListScreen(
        state = state,
        modifier = modifier,
    )
}

@Composable
private fun ProductListScreen(
    state: ProductListState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            ProductListTopBar(state.selectedItemCount)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun ProductListTopBar(
    addedItemCount: Int,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .padding(horizontal = 8.dp),
        title = {
            Text(
                text = stringResource(R.string.product_list_screen_title),
                style = MaterialTheme.typography.titleLarge,
            )
        },
        actions = {
            BadgedBox(
                badge = {
                    if (addedItemCount > 0) {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text("$addedItemCount")
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.product_list_description_shopping_cart),
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
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            state = ProductListState(),
        )
    }
}
