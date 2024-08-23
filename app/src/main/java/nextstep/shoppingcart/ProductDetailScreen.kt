package nextstep.shoppingcart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.detail.ProductDetailButton
import nextstep.shoppingcart.component.detail.ProductDetailImage
import nextstep.shoppingcart.component.detail.ProductDetailPrice
import nextstep.shoppingcart.component.detail.ProductDetailTopBar

@Composable
fun ProductDetailScreen(
    price: Long,
    name: String,
    imageUrl: String,
    onBackClick: () -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ProductDetailTopBar (
                onBackClick = onBackClick
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            ProductDetailImage(
                name = name,
                imageUrl = imageUrl
            )
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(18.dp)
            )

            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.gray))
            )

            ProductDetailPrice(price)

            Spacer(modifier = Modifier.weight(1f))

            ProductDetailButton { onCartClick() }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        price = 1_900_000,
        name = "상품명",
        imageUrl = "",
        onBackClick = {},
        onCartClick = {}
    )
}