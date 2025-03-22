package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.PreviewParameter
import nextstep.shoppingcart.data.ShoppingListPreviewParameterProvider

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    products: List<Product> = emptyList(),
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartTopAppBar(onBackClick = onBackClick)
        },
//        containerColor = Color.White
    ) { paddingValues ->
        Surface(
            modifier = modifier.padding(paddingValues),
            contentColor = Color.White
        ) {
            LazyColumn {
                items(items = products) { product ->
                    CartItem(
                        product = product,
                        quantity = 2,
                        onQuantityChange = {},
                        onRemove = {}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview(
    @PreviewParameter(ShoppingListPreviewParameterProvider::class) products: List<Product>
) {
    ShoppingCartTheme {
        ShoppingCartScreen(
            products = products,
        )
    }
}