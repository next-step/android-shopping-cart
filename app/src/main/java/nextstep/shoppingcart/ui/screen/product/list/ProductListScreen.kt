package nextstep.shoppingcart.ui.screen.product.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.CountIndicator
import nextstep.shoppingcart.ui.component.PriceText
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.ProductTitle
import nextstep.shoppingcart.ui.screen.cart.CartBox
import nextstep.shoppingcart.ui.screen.cart.CartItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    cart: List<CartItem>,
    onClickCart: () -> Unit,
    onClickDetail: (Long) -> Unit
) {
    val cartBox by remember {
        mutableStateOf(cart)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.product_list)) },
                actions = {
                    IconButton(onClick = onClickCart) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(R.string.cart)
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues = innerPadding),
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(vertical = 13.dp, horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 12.dp)
        ) {
            items(items = cartBox) { item ->
                var cartCount by remember {
                    mutableIntStateOf(item.count)
                }
                Column(modifier = Modifier.clickable { onClickDetail(item.product.id) }) {
                    ProductImage(
                        item = item.product,
                        cartCount = cartCount,
                        onClickInc = {
                            cartCount += 1
                            CartBox.add(product = item.product)
                        },
                        onClickDec = {
                            cartCount -= 1
                            CartBox.remove(product = item.product)
                        },
                        onClickAdd = {
                            cartCount = 1
                            CartBox.add(product = item.product)
                        }
                    )
                    ProductTitle(
                        modifier = Modifier.padding(top = 8.dp),
                        title = item.product.name,
                        fontSize = 16.sp
                    )
                    PriceText(
                        modifier = Modifier.padding(top = 2.dp),
                        price = item.product.price,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun ProductImage(
    item: Product,
    cartCount: Int,
    onClickInc: () -> Unit,
    onClickDec: () -> Unit,
    onClickAdd: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        ProductImage(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = item.imageUrl
        )
        val modifier = Modifier
            .padding(end = 12.dp, bottom = 12.dp)
        if (cartCount > 0) {
            CountIndicator(
                modifier = modifier,
                count = cartCount,
                onClickInc = {
                    onClickInc()
                },
                onClickDec = {
                    onClickDec()
                }
            )
            return
        }
        Image(
            modifier = modifier
                .size(size = 42.dp)
                .clip(shape = CircleShape)
                .background(color = Color.White)
                .clickable {
                    onClickAdd()
                }
                .padding(all = 9.dp),
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_cart),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ProductListScreen(
        cart = CartItem.fixture,
        onClickCart = {},
        onClickDetail = {}
    )
}
