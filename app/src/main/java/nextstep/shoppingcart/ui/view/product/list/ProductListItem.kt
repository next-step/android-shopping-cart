package nextstep.shoppingcart.ui.view.product.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.model.dummyProducts

@Composable
fun ProductListItem(
    product: Product,
    onClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable { onClick(product) },
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = product.imageUrl,
            contentDescription = product.name,
            loading = {
                CircularProgressIndicator()
            },
            success = {
                Image(painter = it.painter, contentDescription = "")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = product.name,
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.product_list_product_item_price_fmt, product.price),
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
private fun ProductListItemPreview() {
    ProductListItem(
        product = dummyProducts.first(),
        onClick = {},
    )
}
