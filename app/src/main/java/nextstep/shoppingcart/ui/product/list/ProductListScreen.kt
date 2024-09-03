package nextstep.shoppingcart.ui.product.list

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.productList
import nextstep.shoppingcart.ui.cart.CartActivity
import nextstep.shoppingcart.ui.component.ProductItem
import nextstep.shoppingcart.ui.product.detail.ProductDetailActivity
import nextstep.shoppingcart.ui.product.detail.ProductDetailActivity.Companion.EXTRA_PRODUCT
import nextstep.shoppingcart.ui.theme.BlackTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val cartList by remember {
        derivedStateOf { Cart.items }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = BlackTitle,
                ),
                title = {
                    Text(
                        text = "상품 목록",
                        fontSize = 22.sp
                    )
                },
                actions = {
                    IconButton(onClick = { moveToShoppingCartScreen(context) }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Cart",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .background(Color.White)
                .padding(vertical = 13.dp, horizontal = 18.dp)
                .padding(innerPadding)
        ) {
            items(productList) { product ->
                val productCount by remember(cartList, product) {
                    derivedStateOf {
                        cartList.find { it.product == product }?.count ?: 0
                    }
                }

                ProductItem(
                    count = productCount,
                    product = product,
                    onItemClick = {
                        val intent = Intent(context, ProductDetailActivity::class.java).apply {
                            putExtra(EXTRA_PRODUCT, product)
                        }
                        context.startActivity(intent)
                    },
                    onClickIncrease = { Cart.addOne(product) },
                    onClickDecrease = { Cart.removeOne(product) },
                )
            }
        }
    }
}

private fun moveToShoppingCartScreen(context: Context) {
    val intent = Intent(context, CartActivity::class.java)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview() {
    ProductListScreen()
}
