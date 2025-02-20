package nextstep.shoppingcart.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.topbar.CenterTitleTopBar
import nextstep.shoppingcart.components.topbar.TopBarActionType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    products: Products,
    cart: Cart,
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
        ProductListScreen(
            products = products,
            cart = cart,
            onAddOneClick = onAddOneClick,
            onRemoveOneClick = onRemoveOneClick,
            onProductClick = onProductClick,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    ShoppingCartTheme {
        MainScreen(
            products = FakeProductRepository.getAllProducts(),
            cart = Cart(),
            onActionCartClick = {},
            onAddOneClick = {},
            onRemoveOneClick = {},
            onProductClick = {},
        )
    }
}
