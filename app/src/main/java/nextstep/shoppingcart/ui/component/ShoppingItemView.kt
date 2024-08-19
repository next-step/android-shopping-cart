package nextstep.shoppingcart.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
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
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
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
        Text(
            text = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            maxLines = 1,
            softWrap = true,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            color = Color.Black,
        )
        Text(
            text = "${product.price}원",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun ShoppingItemViewPreview() {
    Surface {
        ShoppingItemView(Product(name = "name", price = "price", description = "description"))
    }
}
