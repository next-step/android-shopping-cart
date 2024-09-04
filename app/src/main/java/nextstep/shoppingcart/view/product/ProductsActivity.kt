package nextstep.shoppingcart.view.product

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.view.product.detail.ProductDetailActivity
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                var buttonClickState by remember { mutableStateOf(false) }

                ProductsScreen(
                    onItemClick = { product ->
                        val intent = Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra("product_name", product.name)
                            putExtra("product_image_url", product.imageUrl)
                            putExtra("product_price", product.price)
                        }
                        startActivity(intent)
                    },
                    onItemButtonClick = { product ->
                        buttonClickState = !buttonClickState
                        Cart.addOne(product)
                    },
                    onAddClicked = { product ->
                        buttonClickState = !buttonClickState
                        Cart.addOne(product)
                    },
                    onRemoveClicked = { product ->
                        buttonClickState = !buttonClickState
                        Cart.removeOne(product)
                    },
                    buttonClickState = buttonClickState,
                )
            }
        }
    }
}
