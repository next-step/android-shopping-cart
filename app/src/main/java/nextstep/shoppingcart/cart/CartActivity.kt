package nextstep.shoppingcart.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                var cartItems by remember { mutableStateOf(Cart.items) }

                CartScreen(
                    cartItems = cartItems,
                    totalPrice = Cart.totalPrice,
                    onBackButtonClick = { finish() },
                    onDeleteButtonClick = {
                        Cart.removeAll(it.product)
                        cartItems = Cart.items
                    },
                    onMinusButtonClick = {
                        Cart.removeOne(it.product)
                        cartItems = Cart.items
                    },
                    onPlusButtonClick = {
                        Cart.addOne(it.product)
                        cartItems = Cart.items
                    },
                )
            }
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CartActivity::class.java))
        }
    }
}

@Preview
@Composable
private fun ProductDetailActivityPreview() {
    ShoppingCartTheme {
        CartScreen(
            cartItems = Cart.items,
            totalPrice = Cart.totalPrice,
            onBackButtonClick = { },
            onDeleteButtonClick = { },
            onMinusButtonClick = { },
            onPlusButtonClick = { },
        )
    }
}