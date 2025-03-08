package nextstep.shoppingcart.productList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productDetail.ProductDetailActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                val productToCount = DummyProduct.productDummyList.map {
                    it to (Cart.getCartCount(it))
                }

                val products: SnapshotStateList<Pair<Product, Int>> =
                    productToCount.toMutableStateList()
                val totalCount = products.sumOf { it.second }

                ProductListScreen(
                    productAndCountList = products,
                    totalCount = totalCount,
                    onItemClick = { product ->
                        ProductDetailActivity.start(this, product)
                    },
                    onCartButtonClick = {
                        CartActivity.start(this)
                    },
                    onPlushClick = { product ->
                        Cart.addOne(product)
                    },
                    onMinusClick = { product ->
                        Cart.removeOne(product)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListActivityPreview() {
    val productAndCountList = DummyProduct.productDummyList.map {
        it to (Cart.getCartCount(it))
    }

    ShoppingCartTheme {
        ProductListScreen(
            productAndCountList = productAndCountList,
            totalCount = 0,
            onItemClick = {},
            onCartButtonClick = {},
            onPlushClick = {},
            onMinusClick = {},
        )
    }
}
