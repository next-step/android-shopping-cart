package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.BlueRectangleButton
import nextstep.shoppingcart.ui.screen.component.PriceText
import nextstep.shoppingcart.ui.screen.component.ProductImage
import nextstep.shoppingcart.ui.theme.Black33
import nextstep.shoppingcart.ui.theme.Gray10

@Composable
fun ProductDetailScreen(
    product: Product,
    addProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
    ) {
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        TitleSector(
            title = product.title,
            modifier = Modifier.padding(18.dp, 18.dp, 18.dp, 0.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .height(1.dp)
                .background(Gray10),
        )
        PriceSector(
            price = product.price,
            modifier = Modifier.padding(18.dp, 18.dp, 18.dp, 0.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        ShoppingCartAddButton(
            onClick = { addProductClick(product) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun TitleSector(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        color = Black33,
    )
}

@Composable
private fun PriceSector(
    price: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = "금액",
            fontWeight = FontWeight.W400,
            fontSize = 24.sp,
            color = Black33,
        )
        Spacer(
            modifier = Modifier.weight(1f),
        )
        PriceText(
            price = price,
            fontSize = 24.sp,
            fontColor = Black33,
        )
    }
}

@Composable
private fun ShoppingCartAddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BlueRectangleButton(
        buttonTitle = stringResource(id = R.string.cart_add_button),
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun TitleSectorPreview() {
    TitleSector(
        title = "상품 이름",
    )
}

@Preview(showBackground = true)
@Composable
private fun PriceSectorPreview() {
    PriceSector(
        price = 10000,
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartAddButtonPreview() {
    ShoppingCartAddButton(
        onClick = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            imageUrl = "https://picsum.photos/200/300",
            title = "상품 이름",
            price = 10000,
        ),
        addProductClick = { }
    )
}