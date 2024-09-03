package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.data.productList
import nextstep.shoppingcart.ui.theme.BlackContent

@Composable
fun ProductItem(
    count: Int,
    product: Product,
    onItemClick: () -> Unit,
    onClickIncrease: (Product) -> Unit,
    onClickDecrease: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(156.dp)
            .clickable(onClick = onItemClick)
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(158.dp)
            )
            if (count == 0) {
                CircleButton(
                    onClick = { onClickIncrease(product) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                )
            } else {
                Counter(
                    onClickDecrease = { onClickDecrease(product) },
                    onClickIncrease = { onClickIncrease(product) },
                    count = count,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp)
                )
            }
        }

        Text(
            text = product.name,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            maxLines = 1,
            fontWeight = Bold,
            color = BlackContent,
            overflow = TextOverflow.Ellipsis
        )
        PriceLabel(
            price = product.price,
            modifier =Modifier.fillMaxWidth().padding(top = 2.dp),
        )
    }
}

@Composable
fun CircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = modifier.size(42.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가하기",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        count = 1,
        product = productList[0],
        {}, {} ,{}
    )
}

@Preview(showBackground = true)
@Composable
fun LongNameProductItemPreview() {
    ProductItem(
        count = 1,
        product = Product(
            name = "iPhone 15 Pro Extra Ultra Premium",
            imageUrl = "",
            price = 10000000
        )
        , {}, {}, {}
    )
}

@Preview(showBackground = true)
@Composable
fun ProductItemEmptyPreview() {
    ProductItem(
        count = 0,
        product = productList[0],
        {}, {} ,{}
    )
}
