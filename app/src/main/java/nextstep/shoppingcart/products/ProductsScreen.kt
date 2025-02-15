package nextstep.shoppingcart.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.grey10
import nextstep.shoppingcart.ui.theme.grey40

@Composable
private fun ProductsTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .padding(12.dp)
                .size(24.dp)
        )
        Text(
            text = stringResource(R.string.products_top_bar_title),
            color = grey10,
            fontWeight = FontWeight.W400,
            style = MaterialTheme.typography.bodyLarge,
        )
        Icon(
            painter = painterResource(R.drawable.ic_shopping_cart),
            contentDescription = "장바구니",
            modifier = Modifier
                .clickable(onClick = {})
                .padding(12.dp)
                .size(24.dp),
        )
    }
}

@Composable
private fun ProductItem(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "상품 이미지",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable(onClick = onClick),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            error = painterResource(R.drawable.ic_launcher_background)
        )
        Text(text = product.name, color = grey40, fontSize = 16.sp, fontWeight = FontWeight.W700)
        Text(
            text = stringResource(R.string.all_price_format).format(product.price),
            color = grey40,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsTopBarPreview() {
    MaterialTheme {
        ProductsTopAppBar()
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    MaterialTheme {
        ProductItem(
            Product(
                id = 1L,
                name = "상품1",
                price = 10000L,
                imageUrl = "https://picsum.photos/200",
            ),
            onClick = {}
        )
    }
}

