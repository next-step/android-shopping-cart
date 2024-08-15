package nextstep.shoppingcart.ui.shopping.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shopping.model.Product
import nextstep.shoppingcart.ui.theme.ListItemTextColor

@Composable
fun ProductListItem(product: Product) {
    Column {
        ListItemImage(product.imageUrl)
        ListItemName(product.name)
        ListItemPrice(product.price)
    }
}

@Composable
private fun ListItemImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .aspectRatio(1f),
        placeholder = painterResource(id = R.drawable.ic_launcher_background)
    )
}

@Composable
private fun ListItemName(name: String) {
    Text(
        text = name,
        modifier = Modifier.padding(
            start = 4.dp,
            end = 4.dp,
            top = 8.dp
        ),
        color = ListItemTextColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 14.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun ListItemPrice(price: Long) {
    Text(
        text = stringResource(id = R.string.item_price_format, price),
        modifier = Modifier.padding(horizontal = 4.dp),
        color = ListItemTextColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Preview(
    showBackground = true,
    widthDp = 150
)
@Composable
private fun ListItemNamePreview() {
    val productName = "PET보틀-정사각형-모양"
    ListItemName(name = productName)
}

@Preview(showBackground = true)
@Composable
private fun ListItemPricePreview() {
    val productPrice = 10_000_000L
    ListItemPrice(price = productPrice)
}
