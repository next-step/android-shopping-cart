package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.component.ProductList
import nextstep.shoppingcart.ui.component.ProductListTopAppBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


@Composable
internal fun ProductListScreen(
    productList: List<Product>,
    onTopBarButtonClick: () -> Unit,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val cart = CartRepository.cartState

    ProductListScreen(
        modifier = modifier,
        productList = productList,
        cart = cart,
        onTopBarButtonClick = onTopBarButtonClick,
        onIncreaseClick = { CartRepository.addOne(it) },
        onDecreaseClick = { CartRepository.removeOne(it) },
        onItemClick = onItemClick,
    )
}

@Composable
internal fun ProductListScreen(
    productList: List<Product>,
    cart: Cart,
    onTopBarButtonClick: () -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProductListTopAppBar(
                onClickButton = onTopBarButtonClick
            )
        },
        content = { innerPadding ->
            ProductList(
                modifier = Modifier.padding(innerPadding),
                productList = productList,
                cart = cart,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
                onProductClick = onItemClick,
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            productList = ProductRepository.getProductList(),
            onItemClick = {},
            onTopBarButtonClick = {}
        )
    }
}
