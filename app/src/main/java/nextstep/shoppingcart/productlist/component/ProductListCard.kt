package nextstep.shoppingcart.productlist.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.ProductCard
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.theme.NextStepTheme
import java.util.UUID

@Composable
internal fun ProductListCard(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        ProductCard(
            product = product,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

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
                text = stringResource(R.string.won_unit, product.price),
                style = NextStepTheme.typography.roboto16N,
            )
        }
    }
}

@Preview(widthDp = 600)
@Composable
private fun ProductListCardPreview() {
    MaterialTheme {
        ProductListCard(
            product = Product(
                id = UUID.randomUUID().toString(),
                name = "PET보틀-정사각형처럼 보이는 예쁜 보틀을 팔아요",
                price = 10000,
                imageUrl = "https://picsum.photos/500",
            ),
        )
    }
}