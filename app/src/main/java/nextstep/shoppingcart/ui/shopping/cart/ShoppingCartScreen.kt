package nextstep.shoppingcart.ui.shopping.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.shopping.component.NavTopAppBar
import nextstep.shoppingcart.ui.theme.Blue50


@Composable
fun ShoppingCartScreen(
    onClickNavigateBack: () -> Unit
) {
    var cartItems by remember { mutableStateOf(Cart.items) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CartTopAppBar(onClickNavigateBack)
        },
        bottomBar = {
            CartOrderButton(
                cartItems,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = cartItems,
                    key = { item -> item.product.id }
                ) { item ->
                    CartItemCard(
                        cartItem = item,
                        onClickAddItem = {
                            Cart.addOne(item.product)
                            cartItems = Cart.items
                        },
                        onClickRemoveItem = {
                            Cart.removeOne(item.product)
                            cartItems = Cart.items
                        },
                        onClickRemoveAll = {
                            Cart.removeAll(item.product)
                            cartItems = Cart.items
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CartTopAppBar(
    onClickNavigateBack: () -> Unit
) {
    NavTopAppBar(
        title = stringResource(id = R.string.shopping_cart),
        onClickNavigateBack = { onClickNavigateBack.invoke() }
    )
}

@Composable
fun CartOrderButton(
    cartItems: List<CartItem>,
    modifier: Modifier
) {
    val totalPrice = cartItems.sumOf {
        it.totalPrice
    }

    Button(
        onClick = { },
        modifier = modifier,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50
        ),
        contentPadding = PaddingValues(vertical = 15.dp)
    ) {
        Text(
            text = "${stringResource(id = R.string.do_order)}(${
                stringResource(
                    id = R.string.item_price_format,
                    totalPrice
                )
            })",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPrev() {
    ShoppingCartScreen({})
}

@Preview(showBackground = true)
@Composable
private fun CartTopAppBarPrev() {
    CartTopAppBar(onClickNavigateBack = {})
}
