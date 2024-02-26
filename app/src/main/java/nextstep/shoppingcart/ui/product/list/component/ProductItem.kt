package nextstep.shoppingcart.ui.product.list.component

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
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.CartCountController
import nextstep.shoppingcart.ui.component.ProductImage

@Composable
internal fun ProductItem(
    product: Product,
    count: Int,
    onAddClick: () -> Unit,
    onMinusClick: () -> Unit,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable(onClick = onItemClick)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color(0xFFEDEDED))
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            if (count == 0) {
                AddButton(
                    onClick = onAddClick,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp)
                        .size(42.dp),
                )
            } else {
                Surface(
                    shadowElevation = 2.dp,
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 12.dp),
                ) {
                    CartCountController(
                        count = count,
                        onPlusClick = onAddClick,
                        onMinusClick = onMinusClick,
                    )
                }
            }

        }

        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Text(
            text = stringResource(id = R.string.product_list_price_fmt, product.price),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(42.dp),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White,
        )
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "장바구니 추가",
        )
    }
}

@Preview(showBackground = true, widthDp = 200)
@Preview(showBackground = true, widthDp = 150)
@Composable
private fun ProductItemPreview() {
    MaterialTheme {
        val product = Product(id = "1", name = "PET보틀-원형(500ml)", price = 42200, imageUrl = "")
        ProductItem(
            product = product,
            count = 0,
            onAddClick = { },
            onMinusClick = { },
            onItemClick = { },
        )
    }
}
