package nextstep.shoppingcart.features.productdetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.MainButton
import nextstep.shoppingcart.components.ProductImage
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun ProductDetail(
    product: Product,
    onAddCartClick: () -> Unit,
    modifier: Modifier = Modifier,
    addCartEnabled: Boolean = true,
) {
    Column(modifier = modifier) {
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f)
        )
        ProductTitle(
            title = product.name,
            modifier = Modifier.padding(18.dp),
        )
        HorizontalDivider(color = GrayAAAAAA)
        ProductPrice(
            price = product.price.value,
            modifier = Modifier.padding(18.dp),
        )
        Spacer(Modifier.weight(1f))
        MainButton(
            text = stringResource(R.string.product_detail_add_cart),
            onClick = onAddCartClick,
            enabled = addCartEnabled,
        )
    }
}

@Composable
private fun ProductTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = Typography.headlineSmall.copy(fontWeight = FontWeight.W700),
        modifier = modifier,
    )
}

@Composable
private fun ProductPrice(price: Int, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.price),
            style = Typography.headlineSmall,
        )
        Text(
            text = stringResource(R.string.price_format, price),
            style = Typography.headlineSmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailPreview() {
    ShoppingCartTheme {
        ProductDetail(
            product = FakeProductRepository.getFirstProduct(),
            onAddCartClick = {},
            addCartEnabled = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailWithProductNotFoundPreview() {
    ShoppingCartTheme {
        ProductDetail(
            product = Product.NotFound,
            onAddCartClick = {},
            addCartEnabled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductTitlePreview() {
    ShoppingCartTheme {
        ProductTitle(title = "Wireless Mouse")
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPricePreview() {
    ShoppingCartTheme {
        ProductPrice(price = 10000)
    }
}
