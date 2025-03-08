package nextstep.shoppingcart.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.list.component.ProductList
import nextstep.shoppingcart.list.component.ProductListTopAppBar
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            ProductListTopAppBar(
                title = stringResource(R.string.product_list),
                navigateToCart = {
                    context.startActivity(CartActivity.intent(context))
                }
            )
        }
    ) { innerPadding ->
        ProductList(
            modifier = modifier.padding(innerPadding),
            products = products
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            products = List(10) {
                Product(
                    id = it,
                    imageUrl = "https://picsum.photos/id/1/300/300",
                    name = "PET보틀-정사각형 어쩌구",
                    price = 10000
                )
            }
        )
    }
}
