package nextstep.shoppingcart.ui.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.designsystem.theme.TextColor
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Product

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    item: Product,
    count: Int,
    onClick: (Product) -> Unit = {},
    onAdd: (Product) -> Unit = {},
    onRemove: (Product) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(item) }
    ) {

        ProductImageContainer(
            item = item,
            count = count,
            modifier = Modifier.aspectRatio(1f),
            onAdd = onAdd,
            onRemove = onRemove
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
            text = stringResource(R.string.price, item.price.getFormattedPrice()),
            color = TextColor,
            fontSize = 16.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(item = mockProducts[0], count = 0)
}