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
import nextstep.shoppingcart.component.detail.AddToCartButton
import nextstep.shoppingcart.component.detail.ProductDetailImage
import nextstep.shoppingcart.component.detail.ProductDetailPrice
import nextstep.shoppingcart.component.detail.ProductDetailTopBar
import nextstep.shoppingcart.model.Product

@Composable
fun ProductDetailScreen(
    product: Product,
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
                name = product.name,
                imageUrl = product.imageUrl
            )
            Text(
                text = product.name,
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

            ProductDetailPrice(product.price)

            Spacer(modifier = Modifier.weight(1f))

            AddToCartButton(onClick = onCartClick)
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product ("상품명", "",1_900_000),
        onBackClick = {},
        onCartClick = {}
    )
}