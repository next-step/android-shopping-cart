package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    count: Int = 0,
    onProductClick: (Product) -> Unit = {},
    onIncreaseClick: (Product) -> Unit = {},
    onDecreaseClick: (Product) -> Unit = {},
) {
    Column(
        modifier = modifier
            .clickable {
                onProductClick(product)
            }
    ) {
        ImageWithCartCounter(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            product = product,
            count = count,
            onIncreaseClick = onIncreaseClick,
            onDecreaseClick = onDecreaseClick,
        )
        Text(
            text = product.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color(0xFF333333),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp
            )
        )
        Text(
            text = stringResource(R.string.price_format, product.price),
            maxLines = 1,
            style = TextStyle(
                color = Color(0xFF333333),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp
            )
        )
    }
}

@Composable
private fun ImageWithCartCounter(
    product: Product,
    count: Int,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        ProductImage(
            modifier = Modifier.fillMaxSize(),
            url = product.imageUrl,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        ) {
            if (count > 0) {
                ProductCartCounter(
                    count,
                    onIncreaseClick = { onIncreaseClick(product) },
                    onDecreaseClick = { onDecreaseClick(product) }
                )
            } else {
                IconButton(
                    modifier = Modifier
                        .size(42.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape,
                        )
                        .testTag("add_cart_button"),
                    onClick = { onIncreaseClick(product) }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "add_cart_icon"
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    var count by remember { mutableStateOf(0) }
    ShoppingCartTheme {
        ProductItem(
            product = Product(
                id = 2300,
                name = "Carmella Hardin",
                imageUrl = "https://picsum.photos/200",
                price = 6085
            ),
            count = count,
            onIncreaseClick = { count++ },
            onDecreaseClick = { count-- },
        )
    }
}
