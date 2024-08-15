package nextstep.shoppingcart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductsScreen() {
    ShoppingCartTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ImageLoading()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageLoading(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Set Glide!",
            modifier = modifier
        )
        GlideImage(
            model = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            contentDescription = "test"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingCartTheme {
        ImageLoading()
    }
}