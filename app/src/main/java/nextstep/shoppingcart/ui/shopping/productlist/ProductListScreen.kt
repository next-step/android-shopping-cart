package nextstep.shoppingcart.ui.shopping.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shopping.component.ProductListItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.theme.TitleTextColor


@Composable
fun ProductListScreen(
    onClickItem: (Int) -> Unit,
    onClickShoppingCart: () -> Unit
) {
    val productList = dummyProducts
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ProductListTopAppBar(
                onClickShoppingCart = onClickShoppingCart
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            ProductItems(
                productList = productList,
                onClickItem = onClickItem
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(
    onClickShoppingCart: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { ProductListTitle() },
        actions = {
            IconButton(
                onClick = { onClickShoppingCart.invoke() },
                modifier = Modifier.size(48.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.shopping_cart),
                    modifier = Modifier.size(24.dp)
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
        color = TitleTextColor,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun ProductItems(
    productList: List<Product>,
    onClickItem: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 18.dp,
            top = 13.dp,
            end = 18.dp,
            bottom = 13.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = productList,
            key = { it.imageUrl }
        ) {
            ProductListItem(
                product = it,
                onClickItem = onClickItem
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(
        onClickItem = {},
        onClickShoppingCart = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListTopAppBarPreview() {
    ProductListTopAppBar(
        onClickShoppingCart = {}
    )
}