package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Text(
            text = product.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 4.dp),
        )
        Text(
            text = stringResource(id = R.string.currency_unit, product.price),
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        product = Product(
            id = 1,
            name = "Apple",
            price = 1000,
            imageUrl = "https://picsum.photos/id/237/200/300",
        ),
    )
}