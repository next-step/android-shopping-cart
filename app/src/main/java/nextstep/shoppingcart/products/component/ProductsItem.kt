package nextstep.shoppingcart.products.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.products.ProductItemUiState
import nextstep.shoppingcart.products.formatter.DefaultPriceFormatter
import nextstep.shoppingcart.products.formatter.PriceFormatter

@Composable
fun ProductsItem(
    productItemUiState: ProductItemUiState,
    onItemClick: () -> Unit,
    onFloatingButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    productPriceFormatter: PriceFormatter = DefaultPriceFormatter,
) {
    Column(
        modifier = modifier.clickable(onClick = onItemClick)
    ) {
        ProductImageBox(
            imageUrl = productItemUiState.productImageUrl,
            onFloatingButtonClick = onFloatingButtonClick,
        )

        ProductName(name = productItemUiState.productName)

        ProductPrice(
            price = productItemUiState.productPrice,
            priceFormatter = productPriceFormatter,
        )
    }
}

@Composable
private fun ProductImageBox(
    imageUrl: String,
    onFloatingButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = imageUrl,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        FloatingCirclePlusButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 12.dp, end = 12.dp),
            onClick = onFloatingButtonClick,
        )
    }
}

@Composable
private fun FloatingCirclePlusButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 21.dp),
            )
            .size(42.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Default.Add,
            contentDescription = null,
        )
    }
}

@Composable
private fun ProductName(name: String) {
    Text(
        text = name,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
    )
}

@Composable
private fun ProductPrice(
    price: Int,
    priceFormatter: PriceFormatter = DefaultPriceFormatter,
) {
    Text(
        text = priceFormatter.format(price),
        fontSize = 16.sp,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
fun ProductsItemPreview() {
    ProductsItem(
        productItemUiState = ProductItemUiState(
            productImageUrl = "https://example.com/image.jpg",
            productName = "PET보틀-원형(500ml)",
            productPrice = 13_000,
        ),
        onItemClick = {},
        onFloatingButtonClick = {},
    )
}
