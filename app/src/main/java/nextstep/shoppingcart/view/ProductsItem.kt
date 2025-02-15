package nextstep.shoppingcart.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import nextstep.shoppingcart.model.Product

@Composable
fun ProductsItem(
    product: Product,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .width(158.dp)
            .wrapContentHeight()
            .clickable {
                onClick()
            }
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "product image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(1f)
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(
            text = product.formattedPrice,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}

@Preview
@Composable
private fun ProductsItemPreview() {
    ProductsItem(
        product = Product(
            imageUrl = "",
            name = "상품명상품명상품명상품명상품명상품명상품명상품명",
            price = 10000
        )
    )
}