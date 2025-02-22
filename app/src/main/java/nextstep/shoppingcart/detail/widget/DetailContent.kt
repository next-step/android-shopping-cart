package nextstep.shoppingcart.detail.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.detail.component.DetailOrderButton
import nextstep.shoppingcart.detail.component.DetailProductImage
import nextstep.shoppingcart.detail.component.DetailProductPrice
import nextstep.shoppingcart.detail.component.DetailProductTitle
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun DetailContent(
    product: Product,
    onClickOrderButton: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        DetailProductImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
        )
        DetailProductTitle(
            product.name,
            modifier = Modifier.padding(18.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
        )
        DetailProductPrice(
            product.price,
            modifier = Modifier
                .padding(top = 18.dp)
                .padding(horizontal = 18.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        DetailOrderButton(
            onClickButton = { onClickOrderButton(product) },
            modifier = Modifier.padding(bottom = 10.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailContentPreview() {
    ShoppingCartTheme {
        DetailContent(
            Product(
                id = 1,
                name = "상품",
                price = 40000,
                imageUrl = "https://picsum.photos/id/30/1280/901",
            ),
            onClickOrderButton = {},
        )
    }
}
