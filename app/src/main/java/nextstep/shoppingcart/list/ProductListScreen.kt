package nextstep.shoppingcart.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.list.component.ProductList
import nextstep.shoppingcart.list.component.ProductListTopAppBar
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.list.model.ProductWithCount
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    products: List<ProductWithCount>,
    onClickCart: () -> Unit,
    onClickProduct: (id: Int) -> Unit,
    onChangeCount: (id: Int, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ProductListTopAppBar(
                title = stringResource(R.string.product_list),
                onClickCart = onClickCart,
            )
        }
    ) { innerPadding ->
        ProductList(
            modifier = modifier.padding(innerPadding),
            onClickProduct = onClickProduct,
            products = products,
            onChangeCount = onChangeCount
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        val items = remember {
            mutableStateOf(
                List(10) {
                    ProductWithCount(
                        product = Product(
                            id = it,
                            imageUrl = "https://picsum.photos/id/1/300/300",
                            name = "PET보틀-정사각형 어쩌구",
                            price = 10000
                        ),
                        count = it
                    )
                }
            )
        }
        ProductListScreen(
            products = items.value,
            onClickCart = {},
            onClickProduct = { _ -> },
            onChangeCount = { _, _ -> }
        )
    }
}
