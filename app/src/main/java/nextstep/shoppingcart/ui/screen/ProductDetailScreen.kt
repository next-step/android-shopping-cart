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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.Black33
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.GrayA
import nextstep.shoppingcart.ui.utils.formatter.DefaultMoneyFormatter
import nextstep.shoppingcart.ui.utils.formatter.MoneyFormatter
import nextstep.shoppingcart.R

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
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
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
                .background(GrayA),
        )
        PriceSector(
            price = product.price,
            modifier = Modifier.padding(18.dp, 18.dp, 18.dp, 0.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        ShoppingCartAddButton(
            onClick = { addProductClick(product) },
        )
    }
}

@Composable
fun TitleSector(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        color = Black33,
        modifier = modifier,
    )
}

@Composable
fun PriceSector(
    price: Int,
    modifier: Modifier = Modifier,
    formatter: MoneyFormatter = DefaultMoneyFormatter,
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
        Text(
            text = "${formatter.format(price)}원",
            fontSize = 24.sp,
            color = Black33,
        )
    }
}

@Composable
fun ShoppingCartAddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Blue50),
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = stringResource(id = R.string.cart_add_button),
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            color = Color.White,
        )
    }
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