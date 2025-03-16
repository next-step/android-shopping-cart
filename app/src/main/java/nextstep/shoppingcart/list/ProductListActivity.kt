package nextstep.shoppingcart.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.common.Products
import nextstep.shoppingcart.detail.ProductDetailActivity
import nextstep.shoppingcart.list.model.ProductWithCount
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                val items = remember {
                    derivedStateOf {
                        Products.items.map { product ->
                            ProductWithCount(
                                product,
                                Cart.items.firstOrNull { it.product.id == product.id }?.count ?: 0
                            )
                        }
                    }
                }

                ProductListScreen(
                    products = items.value,
                    onClickProduct = {
                        startActivity(ProductDetailActivity.intent(this, it))
                    },
                    onClickCart = {
                        startActivity(CartActivity.intent(this))
                    },
                    onChangeCount = { id, count ->
                        Cart.changeCount(id, count)
                    }
                )
            }
        }
    }
}
