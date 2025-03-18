package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.ProductRepository
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Product) -> Unit = {}
) {
    val productRepository = ProductRepository()

    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingListTopAppBar()
        },
        content = { contentPadding ->
            ShoppingListColumn(
                modifier = Modifier.padding(contentPadding),
                listOfItems = productRepository.getProducts(),
                onItemClick = onItemClick
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingListScreenPreview() {
    ShoppingCartTheme {
        ShoppingListScreen()
    }
}