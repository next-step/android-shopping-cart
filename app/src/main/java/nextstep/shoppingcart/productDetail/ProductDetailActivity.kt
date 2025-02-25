package nextstep.shoppingcart.productDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    private val productImage: String by lazy {
        intent.getStringExtra(PRODUCT_IMAGE) ?: ""
    }

    private val productName: String by lazy {
        intent.getStringExtra(PRODUCT_NAME) ?: ""
    }

    private val productPrice: Int by lazy {
        intent.getIntExtra(PRODUCT_PRICE, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = Product(
                        name = productName,
                        price = productPrice,
                        imageUrl = productImage
                    ),
                    onBackButtonClick = {
                        finish()
                    },
                    onAddCartClick = { _ ->
                        // TODO - 장바구니 담기
                    }
                )
            }
        }
    }

    companion object {
        const val PRODUCT_IMAGE = "product_image"
        const val PRODUCT_NAME = "product_name"
        const val PRODUCT_PRICE = "product_price"

        fun start(context: Context, product: Product) {
            context.startActivity(Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_IMAGE, product.imageUrl)
                putExtra(PRODUCT_NAME, product.name)
                putExtra(PRODUCT_PRICE, product.price)
            })
        }
    }
}

@Preview
@Composable
private fun ProductDetailActivityPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                name = "상품",
                price = 10000,
                imageUrl = ""
            ),
        )
    }
}