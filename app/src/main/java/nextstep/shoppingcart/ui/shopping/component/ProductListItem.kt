package nextstep.shoppingcart.ui.shopping.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.theme.ItemTextColor

@Composable
fun ProductListItem(
    product: Product,
    count: Int,
    onClickItem: () -> Unit,
    onAddCount: () -> Unit,
    onRemoveCount: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onClickItem() }
    ) {
        Box {
            ListItemImage(product.imageUrl)
            ProductListQuantitySelector(
                count = count,
                onClickShowSelector = onAddCount,
                onClickAddCount = onAddCount,
                onClickRemoveCount = onRemoveCount,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomEnd)
            )
        }
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
fun ProductListQuantitySelector(
    count: Int,
    onClickShowSelector: () -> Unit,
    onClickAddCount: () -> Unit,
    onClickRemoveCount: () -> Unit,
    modifier: Modifier
) {
    if (count == 0) {
        IconButton(
            onClick = { onClickShowSelector() },
            modifier = modifier.background(Color.White, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
    } else {
        QuantitySelector(
            count = count,
            onClickRemoveCount = { onClickRemoveCount() },
            onClickAddCount = { onClickAddCount() },
            modifier = modifier
                .height(42.dp)
                .background(Color.White, RoundedCornerShape(4.dp))
        )
    }
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
    price: Int,
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
    widthDp = 200
)
@Composable
private fun ProductListItemPreview(
    @PreviewParameter(ProductPrevParamProvider::class) dummyProduct: Pair<Product, Int>
) {
    ProductListItem(
        product = dummyProduct.first,
        count = dummyProduct.second,
        onClickItem = {},
        onAddCount = {},
        onRemoveCount = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ListItemImagePreview() {
    AsyncImage(
        model = null,
        contentDescription = null,
        modifier = Modifier.size(156.dp),
        placeholder = painterResource(id = R.drawable.ic_launcher_background)
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
    val productPrice = 10_000_000
    ListItemPrice(price = productPrice)
}

class ProductPrevParamProvider : PreviewParameterProvider<Pair<Product, Int>> {
    override val values = sequenceOf(
        dummyProducts[0] to 0,
        dummyProducts[1] to 1
    )
}
