package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingItem(
    product: Product,
    modifier: Modifier = Modifier,
    onItemClick: (Product) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(product) }),
    ) {
        AsyncImage(
            modifier = modifier.fillMaxWidth(),
            model = product.imageUrl,
            placeholder = painterResource(R.drawable.ic_photo),
            error = painterResource(R.drawable.ic_photo),
            contentDescription = product.name,
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier = modifier.padding(start = 4.dp),
            text = product.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = modifier.padding(start = 4.dp),
            text = "${product.price}원"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShoppingItemPreview() {
    ShoppingCartTheme {
        ShoppingItem(
            product = Product(
                "https://s3-alpha-sig.figma.com/img/05ef/e578/d81445480aff1872344a6b1b35323488?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=iAnCjlosczr-wNaf-XUWxSynLvrnjQ8SwbkO7YN2A9cpfw8wcUsrMIpi6HDyslQFsSZ1pyb81Gw3LSDsplfPfSS9QDBa5sSCorviFhyBdsWBeU77xktfS3b3iID0cIbtEoLrag09FgNm4jVlLQdpNXPv98G3vGCk7FdVxgVSjdOMRUpCOeuEqEZX2agJtgebpfdcEz4ZfCqXxxkKa0epVujkqudUiu9iReulyaNMtUWZWzbF0zmj4-F2rVjK8M2rX~OfswEvRv3Mxu2qTrO8xRyL36~3VDIxdlpzIKrM0gGtBBpQ73XsmzugfyyOHk2Ak8PB5GKgBC0XZnthpAL3Lg__",
                "PET보틀-정사각...",
                10000
            )
        )
    }
}