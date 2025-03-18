package nextstep.shoppingcart

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.productdetail.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product: Product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("product", Product::class.java)
                ?: throw IllegalArgumentException("Product is required")
        } else {
            intent.getParcelableExtra("product")
                ?: throw IllegalArgumentException("Product is required")
        }

        setContent {
            ShoppingCartTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductDetailScreen(
                        product = product,
                        onBackClick = { finish() }
                    )
                }
            }
        }
    }
}