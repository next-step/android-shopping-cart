package nextstep.shoppingcart.productlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.CounterButton
import nextstep.shoppingcart.common.ProductImage
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductItem(
    product: Product,
    count: Int = 0,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onAddClick: () -> Unit = {},
    onPlusClick: () -> Unit = {},
    onMinusClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box {
            ProductImage(
                modifier = modifier.aspectRatio(1f),
                imageUrl = product.imageUrl
            )
            if (count > 0) {
                CounterButton(
                    modifier = Modifier.align(Alignment.BottomCenter).padding(4.dp),
                    quantity = count,
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick
                )
            } else {
                AddCartButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(4.dp),
                    onClick = onAddClick
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(id = R.string.format_price_won, product.price),
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun AddCartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(R.string.plus))
    }
}

private class ProductCountProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = sequenceOf(0, 1, 2)
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview(@PreviewParameter(ProductCountProvider::class) count: Int) {
    ShoppingCartTheme {
        ProductItem(
            product = Product(
                id = "",
                imageUrl = "https://picsum.photos/200",
                name = "셀프 마라탕 (기본 12000원)",
                price = 85000000
            ),
            count = count,
            modifier = Modifier.width(150.dp)
        )
    }
}

@Preview
@Composable
private fun AddCartButtonPreview() {
    ShoppingCartTheme {
        AddCartButton(
            onClick = {}
        )
    }
}