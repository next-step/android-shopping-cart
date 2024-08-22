package nextstep.shoppingcart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.ui.detail.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val product = intent.getParcelableExtra("product", Product::class.java)!!

                    ProductDetailScreen(
                        product = Product(
                            imageUrl = product.imageUrl,
                            name = product.name,
                            price = product.price
                        ),
                        onNavigationClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}
