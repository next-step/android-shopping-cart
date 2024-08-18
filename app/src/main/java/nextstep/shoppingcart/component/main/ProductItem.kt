package nextstep.shoppingcart.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    price: Long
) {
    Column {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = imageUrl,
            contentDescription = name,
        )
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = NumberFormat.getNumberInstance(Locale.KOREA).format(price) + "원",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000
        )
    }
}