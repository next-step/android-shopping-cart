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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.common.component.CartItemCounter
import nextstep.shoppingcart.ui.common.component.Image
import nextstep.shoppingcart.ui.theme.Black10

@Composable
fun ProductListItem(
    item: Product,
    count: Int,
    onClick: (Product) -> Unit,
    onClickCountIncrease: () -> Unit,
    onClickCountDecrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clickable { onClick(item) }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
        ) {
            Image(
                url = item.imageUrl,
                modifier = Modifier.fillMaxSize(),
            )

            if (count == 0) {
                IconButton(
                    onClick = onClickCountIncrease,
                    modifier = Modifier
                        .padding(end = 12.dp, bottom = 12.dp)
                        .size(42.dp)
                        .background(color = White, shape = CircleShape)
                        .align(Alignment.BottomEnd),
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                }
            } else if (count > 0) {
                CartItemCounter(
                    count = count,
                    onClickIncrease = onClickCountIncrease,
                    onClickDecrease = onClickCountDecrease,
                    modifier = Modifier
                        .padding(end = 12.dp, bottom = 12.dp)
                        .align(Alignment.BottomEnd),
                )
            }
        }

        Text(
            text = item.name,
            color = Black10,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )

        Text(
            text = stringResource(id = R.string.price_format, item.price),
            color = Black10,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview(
    @PreviewParameter(ProductListItemPreviewParameterProvider::class) param: Int,
) {
    val item = Product(
        name = "iPhone 15 Pro Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 1_900_000,
    )
    ProductListItem(
        item = item,
        count = param,
        onClick = {},
        onClickCountDecrease = {},
        onClickCountIncrease = {},
    )
}

private class ProductListItemPreviewParameterProvider : PreviewParameterProvider<Int> {

    override val values: Sequence<Int>
        get() = sequenceOf(0, 1)
}
