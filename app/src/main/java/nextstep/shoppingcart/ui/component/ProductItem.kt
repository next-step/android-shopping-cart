package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.theme.BlackContent

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .width(156.dp)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(158.dp)
        )
        Text(
            text = product.name,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            maxLines = 1,
            fontWeight = Bold,
            color = BlackContent
        )
        Text(
            text = product.price.toString(),
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
            color = BlackContent
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(dummyProducts[0])
}
