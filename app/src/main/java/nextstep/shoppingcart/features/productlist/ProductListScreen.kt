package nextstep.shoppingcart.features.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.topbars.CenterTitleTopBar
import nextstep.shoppingcart.components.topbars.TopBarActionType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Count
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.features.productlist.components.ProductListItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import kotlin.random.Random
import kotlin.random.nextInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    items: Map<Product, CartItem?>,
    onAddOneClick: (Product) -> Unit,
    onRemoveOneClick: (Product) -> Unit,
    onActionCartClick: () -> Unit,
    onProductClick: (Product) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            CenterTitleTopBar(
                title = stringResource(R.string.product_list_top_bar_title),
                action = TopBarActionType.CART,
                onActionClick = onActionCartClick,
                scrollBehavior = scrollBehavior,
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.White,
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 18.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                key = { it.id },
                items = items.keys.toList()
            ) { product ->
                ProductListItem(
                    product = product,
                    count = items[product]?.count?.value,
                    onAddOneClick = { onAddOneClick(product) },
                    onRemoveOneClick = { onRemoveOneClick(product) },
                    onProductClick = { onProductClick(product) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            items = FakeProductRepository.getAllProducts().value.associateWith { product ->
                if (product.id % 2 == 0) null
                else CartItem(product, count = Count.of(Random.nextInt(1..5)))
            },
            onAddOneClick = {},
            onRemoveOneClick = {},
            onActionCartClick = {},
            onProductClick = { }
        )
    }
}

