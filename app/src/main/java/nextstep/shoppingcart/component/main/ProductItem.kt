package nextstep.shoppingcart.component.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.component.common.ProductImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductItem(
    name: String,
    imageUrl: String,
    price: Long,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            ProductImage(
                modifier = Modifier.fillMaxSize(),
                imageUrl = cartItem.product.imageUrl,
                contentDescription = cartItem.product.name,
            )
            FloatingActionButton(
                onClick = onAddToCart,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd),
                containerColor = Color.White,
                contentColor = Color.Black,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add to cart",
                )
            }
        }
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = NumberFormat.getNumberInstance(Locale.KOREA).format(price) + "원",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
            onAddToCart = {}
        )
    }
}