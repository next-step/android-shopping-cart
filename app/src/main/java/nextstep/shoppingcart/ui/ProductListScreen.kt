package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartProductModel
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.component.Product
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    items: List<CartProductModel>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ShoppingCartTopBar(
                titleResId = R.string.product_list,
                isCenter = true,
                showCartButton = true,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("productListLazyVerticalGrid"),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp)
            ) {
                items(
                    items = items,
                    key = { model -> model.id }
                ) { model ->
                    Product(model.product, model.count)
                }
            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(dummyProducts.map { CartProductModel(it, Cart.productCount(it)) })
    }
}