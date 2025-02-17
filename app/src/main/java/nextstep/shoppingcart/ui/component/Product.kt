package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.navigator.toProductDetail
import nextstep.shoppingcart.ui.component.preview.ProductParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun Product(
    model: ProductModel,
    count: Int,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(modifier = modifier.clickable {
        context.toProductDetail(model)
    }) {
        ProductThumbnail(model = model, count = count)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = model.name,
            style = Typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier
                .heightIn(min = 20.dp)
                .padding(horizontal = 4.dp),
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.height(2.dp))
        PriceText(
            price = model.price,
            style = Typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}

@Composable
private fun ProductThumbnail(
    model: ProductModel,
    count: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        Thumbnail(
            id = model.id,
            imageUrl = model.imageUrl,
            name = model.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        if (count == 0) {
            Box(modifier = Modifier.padding(12.dp)) {
                Icon(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { Cart.addOne(model) }
                        .background(color = Color.White)
                        .size(42.dp)
                        .padding(13.dp),
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(R.string.add),
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                contentAlignment = Alignment.Center
            ) {

                CountControlButton(
                    count = count,
                    onAddClick = { Cart.addOne(model) },
                    onRemoveClick = { Cart.removeOne(model) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview(@PreviewParameter(ProductParameterProvider::class) model: ProductModel) {
    ShoppingCartTheme {
        Product(model = model, count = 0)
    }
}