package nextstep.shoppingcart.productlist.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.ProductCard
import nextstep.shoppingcart.common.component.QuantitySelector
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.theme.NextStepTheme
import java.text.NumberFormat
import java.util.Locale
import java.util.UUID

@Composable
internal fun ProductListScreenCard(
    product: Product,
    count: Int,
    onCountAddClick: () -> Unit,
    onCountMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Box {
            ProductCard(
                product = product,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            AddToCartButton(
                count = count,
                onCountAddClick = onCountAddClick,
                onCountMinusClick = onCountMinusClick,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = product.name,
                style = NextStepTheme.typography.roboto16B,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = stringResource(
                    R.string.won_unit,
                    NumberFormat.getNumberInstance(Locale.KOREA).format(product.price)
                ),
                style = NextStepTheme.typography.roboto16N,
            )
        }
    }
}

@Composable
private fun BoxScope.AddToCartButton(
    count: Int,
    onCountAddClick: () -> Unit,
    onCountMinusClick: () -> Unit,
) {
    if (count == 0) {
        Surface(
            modifier = Modifier
                .padding(12.dp)
                .size(42.dp)
                .align(Alignment.BottomEnd),
            onClick = onCountAddClick,
            shape = CircleShape,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.padding(13.dp)
            )
        }
    } else {
        QuantitySelector(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            count = count,
            onCountAddClick = onCountAddClick,
            onCountMinusClick = onCountMinusClick,
        )
    }
}

@Preview(widthDp = 156, heightDp = 198)
@Composable
private fun ProductListCardPreview() {
    MaterialTheme {
        ProductListScreenCard(
            product = Product(
                id = UUID.randomUUID().toString(),
                name = "PET보틀-정사각형처럼 보이는 예쁜 보틀을 팔아요",
                price = 10000,
                imageUrl = "https://picsum.photos/500",
            ),
            count = 1,
            onCountAddClick = {},
            onCountMinusClick = {},
        )
    }
}