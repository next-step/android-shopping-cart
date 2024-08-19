package nextstep.shoppingcart.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "상품 목록",
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Handle navigation icon click */ }) {

            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle action icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Cart Icon"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProductsTopAppBarPreview() {
    ProductsTopAppBar()
}
