package nextstep.shoppingcart.ui.shopping.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Typography


@Composable
fun ProductListScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ProductListTopAppBar(modifier = Modifier)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ProductItems()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(modifier: Modifier) {
    CenterAlignedTopAppBar(
        title = { ProductListTitle() },
        modifier = modifier,
        actions = {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.shopping_cart),
                    tint = Color.Black
                )
            }
        }
    )
}

@Composable
fun ProductListTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.product_list),
        modifier = modifier,
        color = Color(0xFF1D1B20),
        style = Typography.titleLarge
    )
}

@Composable
fun ProductItems(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen()
}
