package nextstep.shoppingcart.catalog.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.TypoTokens.Bold16
import nextstep.shoppingcart.ui.theme.TypoTokens.Normal16
import nextstep.shoppingcart.util.NumberFormatUtil.toPrice

@Composable
fun ProductGridItem(
    product: Product,
    count: Int,
    isAdded: Boolean,
    onClickAddCartButton: (Product) -> Unit,
    onClickIncreaseCountButton: (Product) -> Unit,
    onClickDecreaseCountButton: (Product) -> Unit,
    onClickProductItem: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable { onClickProductItem.invoke(product) }) {
        ProductQuantityAdjustImage(
            product = product,
            count = count,
            isAdded = isAdded,
            onClickAddCartButton = onClickAddCartButton,
            onClickIncreaseCountButton = onClickIncreaseCountButton,
            onClickDecreaseCountButton = onClickDecreaseCountButton,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            product.name,
            style = Bold16,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            product.price.toPrice(),
            style = Normal16,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductGridItemPreview() {
    ProductGridItem(
        product = Product(
            id = 1,
            name = "엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마엄청난글자수를보여주마",
            price = 1000,
            imageUrl = "https://picsum.photos/id/30/1280/901"
        ),
        count = 1,
        isAdded = true,
        onClickAddCartButton = {},
        onClickIncreaseCountButton = {},
        onClickDecreaseCountButton = {},
        onClickProductItem = {},
    )
}
