package nextstep.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class ProductDetailActivity : ComponentActivity() {
    private val productId: Int by lazy {
        val value = intent.getIntExtra(PRODUCT_ID, ERROR_PRODUCT_ID)
        if (value == ERROR_PRODUCT_ID) throw IllegalArgumentException("productId is required") else value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(productId.toString())
        }
    }

    companion object {
        private const val PRODUCT_ID = "productId"
        private const val ERROR_PRODUCT_ID = Int.MIN_VALUE

        fun getIntent(context: Context, productId: Int): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, productId)
            }
        }
    }
}
