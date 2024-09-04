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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ShoppingItemComponent
import nextstep.shoppingcart.component.topbar.ShoppingListTopBar
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Cart

@Composable
fun ShoppingListScreen(
    navigateToDetail : (Int) -> Unit,
    navigateToCart : () -> Unit,
    modifier: Modifier = Modifier
){
   var cartItemList by remember {
       mutableStateOf(Cart.items)
   }

    ShoppingListScreen(
        productList = productList,
        cartItemList = cartItemList,
        onClickDetail = navigateToDetail,
        onClickCart = navigateToCart,
        onPlusClick = { product ->
            cartItemList = Cart.addOne(product)
        },
        onMinusClick = { product ->
            cartItemList = Cart.removeOne(product)
        },
        modifier = modifier
    )
}

@Composable
fun ShoppingListScreen(
    productList : List<Product>,
    cartItemList : List<CartItem>,
    onClickDetail : (Int) -> Unit,
    onClickCart : () -> Unit,
    onPlusClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingListTopBar(
                title = stringResource(id = R.string.shopping_list_title),
                onClickCart = onClickCart
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
                ShoppingItemComponent(
                    product = product,
                    onClick = {
                        onClickDetail(product.id)
                    },
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick,
                    count = cartItemList.find { it.product.id == product.id }?.count ?: 0
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "ShoppingListScreen")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingListScreen(
            navigateToDetail = {},
            navigateToCart = {}
        )
    }

}