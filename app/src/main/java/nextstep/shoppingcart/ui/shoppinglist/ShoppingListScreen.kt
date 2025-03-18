package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.ProductRepository
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Product) -> Unit = {},
    onShoppingCartClick: () -> Unit = {},
) {
    val productRepository = ProductRepository()

    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingListTopAppBar(onShoppingCartClick = onShoppingCartClick)
        },
        content = { contentPadding ->
            ShoppingListColumn(
                modifier = Modifier.padding(contentPadding),
                listOfItems = productRepository.getProducts(),
                onItemClick = onItemClick
            )
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingListScreenPreview() {
    ShoppingCartTheme {
        ShoppingListScreen()
    }
}