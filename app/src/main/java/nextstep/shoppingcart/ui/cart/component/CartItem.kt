package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.ProductImage

@Composable
internal fun CartItem(
    product: Product,
    count: Int,
    onDeleteClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .border(1.dp, Color(0xFFAAAAAA), RoundedCornerShape(4.dp))
            .padding(vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
            )
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "상품 장바구니 제거"
                )
            }
        }

        Row(modifier = Modifier.padding(horizontal = 12.dp)) {
            ProductImage(
                imageUrl = product.imageUrl,
                modifier = Modifier.size(136.dp, 84.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(modifier = Modifier.align(Alignment.Bottom)) {
                Text(
                    text = stringResource(id = R.string.cart_item_price_fmt, product.price * count),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.End),
                )
                Spacer(modifier = Modifier.height(4.dp))

                CountController(
                    count = count,
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick,
                    modifier = Modifier.align(Alignment.End),
                )
            }
        }
    }
}

@Composable
private fun CountController(
    count: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(onClick = onMinusClick) {
            Text(text = "-", style = MaterialTheme.typography.headlineMedium)
        }
        Text(text = count.toString(), style = MaterialTheme.typography.headlineSmall)
        IconButton(onClick = onPlusClick) {
            Text(text = "+", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    MaterialTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(12.dp),
        ) {
            CartItem(
                product = Products[0],
                count = 1,
                onDeleteClick = { },
                onPlusClick = { },
                onMinusClick = { },
            )
            CartItem(
                product = Products[1],
                count = 2,
                onDeleteClick = { },
                onPlusClick = { },
                onMinusClick = { },
            )
            CartItem(
                product = Products[2],
                count = 6,
                onDeleteClick = { },
                onPlusClick = { },
                onMinusClick = { },
            )
        }
    }
}
