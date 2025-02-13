package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.component.Product
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    products: List<ProductModel>,
    modifier: Modifier = Modifier
) {
    Column {
        ShoppingCartTopBar(
            titleResId = R.string.product_list,
            isCenter = true,
            onClickCart = {},
        )

        LazyVerticalGrid(
            modifier = modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp)
        ) {
            items(
                items = products,
                key = { model -> model.id }
            ) { model ->
                Product(model)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(dummyProducts)
    }
}