package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepository

@Composable
internal fun ProductDetailContent(
    product: Product,
    onAddCartClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState(0)
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            ProductImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                url = product.imageUrl,
            )
            Text(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                text = product.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.5.sp,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF333333),
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0xFFAAAAAA),
            )
            PriceBar(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                price = product.price
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { onAddCartClick(product) },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(R.string.add_shopping_cart),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 23.44.sp,
                )
            )
        }
    }
}

@Composable
private fun PriceBar(
    price: Int,
    modifier: Modifier = Modifier,
) {
    ProvideTextStyle(
        TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            color = Color(0xFF333333)
        )
    ) {
        Row(
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.price),
            )
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.price_format, price),
                textAlign = TextAlign.End,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailContentPreview() {
    ProductDetailContent(
        product = ProductRepository.getProductById(1)
            .copy(name = "매우매우매우길어요매우매우매우길어요매우매우매우길어요매우매우매우길어요"),
        onAddCartClick = {}
    )
}
