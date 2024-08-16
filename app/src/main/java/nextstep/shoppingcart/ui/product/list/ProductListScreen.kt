package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list)) },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "shoppingCartIcon",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(48.dp)
                            .padding(8.dp),
                    )
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            ProductListContent()
        }
    }
}

@Composable
private fun ProductListContent(
    modifier: Modifier = Modifier,
) {
    Text(text = "Hello Product List")
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen()
}