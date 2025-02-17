package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.ProductLazyGrid
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.R

@Composable
fun ProductScreen() {
    val appBarTitle = stringResource(R.string.title_product_list)
    val products: List<Product> = List(20) { _ ->
        Product(
            imageUrl = "https://picsum.photos/600/600",
            name = "상품명",
            price = 10000
        )
    }

    Scaffold(
        topBar = {
            ProductListAppBar(
                title = appBarTitle,
                actionIconOnClick = { },
            )
        },
    ) { innerPadding ->
        ProductLazyGrid(
            products = products,
            onClick = { },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductScreen()
    }
}