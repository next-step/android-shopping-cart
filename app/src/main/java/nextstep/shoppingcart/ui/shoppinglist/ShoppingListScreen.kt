package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.ProductRepository
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.EerieBlack
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier,
) {
    val productRepository = ProductRepository()

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        maxLines = 1,
                        text = stringResource(R.string.shopping_cart_title),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    IconButton(onClick = { /* 검색 버튼 클릭 시 동작 */ }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(R.string.shopping_cart_icon_content_description),
                            tint = EerieBlack
                        )
                    }
                }
            )
        },
        content = { contentPadding ->
            ShoppingListColumn(
                modifier = Modifier.padding(contentPadding),
                listOfItems = productRepository.getProducts()
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