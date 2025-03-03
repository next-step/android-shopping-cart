package nextstep.shoppingcart.catalog.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.BooleanPreviewParameterProvider
import nextstep.shoppingcart.util.ImageUtil.getUrlIfNotPreview

@Composable
fun ProductQuantityAdjustImage(
    product: Product,
    isAdded: Boolean,
    count: Int,
    onClickAddCartButton: (Product) -> Unit,
    onClickIncreaseCountButton: (Product) -> Unit,
    onClickDecreaseCountButton: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = getUrlIfNotPreview(product.imageUrl),
            contentDescription = "${product.name} image",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.woori),
            modifier = Modifier.aspectRatio(1f)
        )

        if (isAdded) {
            ProductCountAdjustButton(
                count = count,
                onClickIncreaseCountButton = { onClickIncreaseCountButton.invoke(product) },
                onClickDecreaseCountButton = { onClickDecreaseCountButton.invoke(product) },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 12.dp)
                    .testTag("${product.id}AdjustButton")
            )
        } else {
            ProductAddCartButton(
                onClickButton = { onClickAddCartButton.invoke(product) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .testTag("${product.id}AddButton")
            )
        }
    }
}

@Preview
@Composable
private fun ProductQuantityAdjustImagePreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class) isAdded: Boolean,
) {
    ShoppingCartTheme {
        ProductQuantityAdjustImage(
            product = Product(
                0,
                "",
                0,
                ""
            ),
            isAdded = isAdded,
            count = 0,
            onClickAddCartButton = {},
            onClickIncreaseCountButton = {},
            onClickDecreaseCountButton = {},
        )
    }
}