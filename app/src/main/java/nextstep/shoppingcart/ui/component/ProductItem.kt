package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.Black
import nextstep.shoppingcart.ui.theme.Gray
import nextstep.signup.R

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val descriptionNavigate = stringResource(R.string.description_product_item_navigate)
    val imageRatio = 156f / 158f

    Column(
        modifier = modifier
            .clickable { onClick() }
            .semantics { contentDescription = descriptionNavigate }
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(imageRatio),
            placeholder = ColorPainter(Gray),
        )
        Column(
            modifier = modifier.padding(
                start = 4.dp,
                top = 8.dp,
                end = 4.dp,
                bottom = 0.dp
            )
        ) {
            Text(
                text = product.name,
                modifier = modifier.fillMaxWidth(),
                color = Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = product.formattedPrice,
                modifier = modifier.fillMaxWidth(),
                color = Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    val dummyItem = Product(
        imageUrl = "https://picsum.photos/600/600",
        name = "상품명상품명상품명상품명상품명상품명상품명상품명상품명상품명상품명",
        price = 10000
    )
    ProductItem(
        product = dummyItem,
        onClick = {}
    )
}