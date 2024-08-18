package nextstep.shoppingcart.ui.shopping.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shopping.model.Product
import nextstep.shoppingcart.ui.theme.ItemTextColor

@Composable
fun ProductListItem(
    product: Product,
    onClickItem: (Int) -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onClickItem.invoke(product.id)
        }
    ) {
        ListItemImage(product.imageUrl)
        ListItemName(
            name = product.name,
            modifier = Modifier.padding(top = 8.dp, start = 4.dp, end = 4.dp)
        )
        ListItemPrice(
            price = product.price,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}

@Composable
private fun ListItemImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        placeholder = painterResource(id = R.drawable.ic_launcher_background)
    )
}

@Composable
private fun ListItemName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        modifier = modifier,
        color = ItemTextColor,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun ListItemPrice(
    price: Long,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.item_price_format, price),
        modifier = modifier,
        color = ItemTextColor,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = MaterialTheme.typography.bodyLarge
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
