package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoTopAppBar
import nextstep.shoppingcart.ui.model.Cart

@Composable
fun ProductCartListScreen(modifier: Modifier = Modifier) {
    var cartItems by remember {
        mutableStateOf(Cart.items)
    }
    val totalPrice by remember(cartItems) {
        mutableLongStateOf(Cart.totalPrice)
    }
    val isCartEmpty by remember {
        derivedStateOf {
            cartItems.isEmpty()
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DinoTopAppBar(
                text = stringResource(R.string.product_cart_list_title),
                navigationBack = true
            )
        }
    ) { paddingValues ->
        if (isCartEmpty) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.product_cart_list_empty_icon)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = stringResource(R.string.product_cart_list_empty_message))
            }

        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
            ) {
                LazyColumn {
                    item {
                        Spacer(modifier = Modifier.size(18.dp))
                    }
                    items(
                        items = cartItems,
                        key = { item -> item.product.name },
                    ) { item ->
                        ProductCartListItem(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            product = item.product,
                            quantity = item.count,
                            onQuantityChange = { newQuantity ->
                                if (item.count > newQuantity) {
                                    cartItems = Cart.removeOne(item.product)
                                } else {
                                    cartItems = Cart.addOne(item.product)
                                }
                            },
                            onClearClick = {
                                cartItems = Cart.removeAll(item.product)
                            }
                        )
                        Spacer(modifier = Modifier.size(18.dp))
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    shape = RectangleShape,
                    contentPadding = PaddingValues(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xff2196F3)
                    ),
                    onClick = { }
                ) {
                    Text(
                        text = stringResource(R.string.product_cart_list_order_button, totalPrice),
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductCartListScreenPreview() {
    ProductCartListScreen()
}
