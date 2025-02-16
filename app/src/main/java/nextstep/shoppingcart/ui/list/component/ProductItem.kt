package nextstep.shoppingcart.ui.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.designsystem.theme.TextColor
import nextstep.shoppingcart.model.Product

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    item: Product,
    onClick: (Product) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(item) }
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            model = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 4.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = TextColor,
            text = item.name
        )

        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = item.price.toString(),
            color = TextColor,
            fontSize = 16.sp
        )

    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(item = mockProducts[0])
}