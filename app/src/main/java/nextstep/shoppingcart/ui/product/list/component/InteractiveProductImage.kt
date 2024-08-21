package nextstep.shoppingcart.ui.product.list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Product

@Composable
fun InteractiveProductImage(product: Product, modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = product.imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(Color.Black)
        )

        SmallFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(26.dp),
            onClick = { {} },
            containerColor = Color.White,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Floating action button.",
            )
        }
    }
}

@Preview
@Composable
private fun InteractiveProductImagePreview() {
    InteractiveProductImage(
        product = Product(
            id = 1,
            name = "Product Name",
            price = 1000,
            imgUrl = "https://www.example.com/image.jpg"
        )
    )
}