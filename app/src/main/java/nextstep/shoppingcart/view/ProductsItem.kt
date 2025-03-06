package nextstep.shoppingcart.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.model.Product

@Composable
fun ProductsItem(
    product: Product,
    onClickItem: (Product) -> Unit,
    onClickAdd: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(158.dp)
            .clickable {
                onClickItem(product)
            }
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1f)
            )
            IconButton(
                onClick = onClickAdd,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(42.dp)
            ) {
                Icon(Icons.Filled.Add, null)
            }
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(
            text = product.formattedPrice,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsItemPreview() {
    ProductsItem(
        product = Product(
            imageUrl = "",
            name = "상품명상품명상품명상품명상품명상품명상품명상품명",
            price = 10000
        ),
        onClickItem = {},
        onClickAdd = {}
    )
}