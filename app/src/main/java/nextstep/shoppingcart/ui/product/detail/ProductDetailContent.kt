package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.BlueBottomButton
import nextstep.shoppingcart.ui.component.PriceLabel
import nextstep.shoppingcart.ui.theme.BlackContent
import nextstep.shoppingcart.ui.theme.LineColor

@Composable
fun ProductDetailContent(
    product: Product,
    onClickCartAddButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ProductImage(
            imageUrl = product.imageUrl,
            description = product.name
        )
        ProductTitle(product.name)
        Divider(color = LineColor)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
        ) {
            Text(
                text = "금액",
                fontSize = 20.sp,
                color = BlackContent
            )
            ProductPrice(product.price)
        }

        Spacer(modifier = Modifier.weight(1.0f, true))

        BlueBottomButton(
            label = "장바구니 담기",
            onClick = onClickCartAddButton,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ProductImage(imageUrl: String, description: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = description,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.0f)
    )
}

@Composable
fun ProductTitle(name: String) {
    Text(
        text = name,
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        maxLines = 1,
        fontWeight = Bold,
        color = BlackContent,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun ProductPrice(price: Long) {
    PriceLabel(
        price = price,
        modifier = Modifier.wrapContentSize(),
        textUnit = 20.sp
    )
}

@Preview(showBackground = true)
@Composable
fun ProductDetailContentPreview() {
    ProductDetailContent(
        product = Product(
            name = "PET보틀-원형(500ml)",
            imageUrl = "",
            price = 42200
        ), {}
    )
}
