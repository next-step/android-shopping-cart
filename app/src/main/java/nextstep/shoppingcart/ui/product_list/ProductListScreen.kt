@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.product_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.designsystem.ProductListItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier
) {
    var state by remember {
        mutableStateOf(ProductListState())
    }

    // viewModel이 없으므로 여기서 아이템 목록을 가져온다.
    LaunchedEffect(true) {
        state = state.copy(isLoading = true)

        state = state.copy(
            products = dummyProducts,
            isLoading = false,
        )
    }

    if (!state.isLoading) {
        ProductListScreen(
            state = state,
            modifier = modifier,
        )
    }
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .padding(paddingValues)
                .padding(horizontal = 18.dp, vertical = 13.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(state.products) { product ->
                ProductListItem(product)
            }
        }
    }
}

@Composable
fun ProductListTopBar(
    addedItemCount: Int,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
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
                },
                modifier = Modifier.padding(end = 4.dp),
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
            state = ProductListState(
                products = listOf(
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-세모",
                        price = 10_000_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 1_000_000_000,
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                )
            ),
        )
    }
}
