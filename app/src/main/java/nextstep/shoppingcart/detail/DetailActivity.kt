package nextstep.shoppingcart.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.getProduct
import nextstep.shoppingcart.model.putProduct
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product = intent.getProduct()

        setContent {
            ShoppingCartTheme {
                if (product != null) {
                    DetailScreen(product)
                } else {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text("Empty")
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context, product: Product) =
            Intent(context, DetailActivity::class.java).apply {
                putProduct(product)
            }
    }
}
