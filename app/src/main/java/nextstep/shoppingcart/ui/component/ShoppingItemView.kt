package nextstep.shoppingcart.ui.component

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.memory.MemoryCache
import coil.util.DebugLogger
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import nextstep.shoppingcart.data.model.Product
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShoppingItemView(product: Product) {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    })

    val sslContext = SSLContext.getInstance("SSL").apply {
        init(null, trustAllCerts, SecureRandom())
    }

    val okHttpClient = OkHttpClient.Builder()
        .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
        .hostnameVerifier { _, _ -> true }
        .build()

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .okHttpClient { okHttpClient }
        .build()

    Column(
        modifier = Modifier
            .width(156.dp)
            .height(198.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .width(156.dp)
                .height(158.dp),
            contentScale = ContentScale.Crop,
            model = product.imageUrl,
            contentDescription = null,
            imageLoader = imageLoader,
            onState = { state ->
                when (state) {
                    is AsyncImagePainter.State.Loading -> {

                    }

                    is AsyncImagePainter.State.Success -> {

                    }

                    is AsyncImagePainter.State.Error -> {
                        Log.d("irondler", "Error = ${state.result.throwable.message}")
                    }

                    else -> {

                    }
                }
            }
        )
        Text(text = product.name)
        Text(text = product.price)
    }
}

@Preview
@Composable
fun ShoppingItemViewPreview() {
    Surface {
        ShoppingItemView(Product(name = "name", price = "price", description = "description"))
    }
}