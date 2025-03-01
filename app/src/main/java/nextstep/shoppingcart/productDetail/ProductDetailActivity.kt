package nextstep.shoppingcart.productDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    private val product: Product by lazy {
        val productId = intent.getIntExtra(PRODUCT_ID, -1)

        if (productId == -1) throw IllegalArgumentException("productId is required")

        DummyProduct.productDummyList.firstOrNull { product ->
            product.id == productId
        } ?: throw IllegalArgumentException("product is not find")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = product,
                    onBackButtonClick = {
                        finish()
                    },
                    onAddCartClick = { product ->
                        Cart.addOne(product)
                    },
                )
            }
        }
    }

    companion object {
        const val PRODUCT_ID = "product_id"

        fun start(context: Context, product: Product) {
            context.startActivity(Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, product.id)
            })
        }
    }
}

@Preview
@Composable
private fun ProductDetailActivityPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = DummyProduct.product1,
            onBackButtonClick = {},
            onAddCartClick = {},
        )
    }
}