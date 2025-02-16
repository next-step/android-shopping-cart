package nextstep.shoppingcart.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.designsystem.theme.TopBarTextColor
import nextstep.shoppingcart.ui.list.component.ProductItem



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.product_list_title),
                        fontSize = 22.sp,
                        color = TopBarTextColor,
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    Image(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(24.dp),
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = null
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = mockProducts,
                key = { item -> item.id }
            ) { item ->
                ProductItem(item = item)
            }
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen()
    }
}