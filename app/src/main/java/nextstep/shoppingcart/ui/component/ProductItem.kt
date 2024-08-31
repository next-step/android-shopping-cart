package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.productList
import nextstep.shoppingcart.ui.theme.BlackContent

@Composable
fun ProductItem(
    product: Product,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(156.dp)
            .clickable(onClick = onItemClick)
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
            color = BlackContent,
            overflow = TextOverflow.Ellipsis
        )
        PriceLabel(
            price = product.price,
            modifier =Modifier.fillMaxWidth().padding(top = 2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(productList[0], {})
}

@Preview(showBackground = true)
@Composable
fun LongNameProductItemPreview() {
    ProductItem(
        Product(
            name = "iPhone 15 Pro Extra Ultra Premium",
            imageUrl = "",
            price = 10000000
        )
        , {}
    )
}
