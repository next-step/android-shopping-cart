package nextstep.shoppingcart.list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.ProductImage
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ProductImage(
            modifier = Modifier
                .fillMaxWidth(),
            imageUrl = product.imageUrl,
            contentDescription = product.name,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp),
            text = product.name,
            style = TextStyle(
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp
            ),
            color = Color(0xFF333333),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 86.dp),
            text = stringResource(R.string.price_format, product.price),
            style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp
            ),
            color = Color(0xFF333333)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview() {
    ShoppingCartTheme {
        ProductListItem(
            product = Product(
                id = 0,
                imageUrl = "https://picsum.photos/id/1/300/300",
                name = "상품명",
                price = 10000
            )
        )
    }
}
