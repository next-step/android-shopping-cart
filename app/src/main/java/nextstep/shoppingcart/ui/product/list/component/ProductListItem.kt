package nextstep.shoppingcart.ui.product.list.component

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
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.common.component.Image
import nextstep.shoppingcart.ui.theme.Black10

@Composable
fun ProductListItem(
    item: Product,
    onClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clickable { onClick(item) }) {
        Image(
            url = item.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
        )

        Text(
            text = item.name,
            color = Black10,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )

        Text(
            text = stringResource(id = R.string.price_format, item.price),
            color = Black10,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview() {
    val item = Product(
        name = "iPhone 15 Pro Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 1_900_000,
    )
    ProductListItem(item = item, onClick = {})
}
