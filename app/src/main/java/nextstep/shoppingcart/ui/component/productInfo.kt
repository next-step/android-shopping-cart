package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.data.Product

@Composable
fun ProductOverview(modifier: Modifier = Modifier, product: Product) {
    // 상품 사진 + 상품명
    AsyncImage(
        modifier = Modifier.height(360.dp),
        model = product.imgUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        placeholder = ColorPainter(Color.Black)
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        text = product.name,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ProductPrice(modifier: Modifier = Modifier, product: Product) {
    Row(
        modifier
    ) {
        Text(
            text = stringResource(id = R.string.text_price),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Start,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(id = R.string.formatted_price, product.price),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.End,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductOverviewPrev() {
    Column {
        ProductOverview(
            Modifier,
            Product(
                id = 1,
                imgUrl = "https://picsum.photos/seed/1/200",
                name = "상품 1-이름이 너무 길다면 어떻게 할 것인가요?",
                price = 3000
            )
        )
    }
}