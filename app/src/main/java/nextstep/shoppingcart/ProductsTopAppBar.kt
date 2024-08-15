package nextstep.shoppingcart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Box(modifier = modifier.fillMaxSize()) {
                Text(
                    text = "상품 목록",
                    textAlign = TextAlign.Center,
                    modifier = modifier.align(Alignment.Center)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Handle navigation icon click */ }) {

            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle action icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Action Icon"
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