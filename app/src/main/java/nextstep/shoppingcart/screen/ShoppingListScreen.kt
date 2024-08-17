package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ShoppingItem
import nextstep.shoppingcart.component.topbar.ShoppingListTopBar
import nextstep.shoppingcart.model.productList

@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingListTopBar(
                title = stringResource(id = R.string.shopping_list_title),
                onClickCart = {

                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                vertical = 13.dp,
                horizontal = 18.dp
            ),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(
                items = productList
            ) { product ->
                ShoppingItem(
                    product = product,
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "ShoppingListScreen")
@Composable
private fun Preview1() {
    ShoppingListScreen()
}