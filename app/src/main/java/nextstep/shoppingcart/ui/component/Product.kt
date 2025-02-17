package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.navigator.toProductDetail
import nextstep.shoppingcart.ui.component.preview.ProductParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun Product(
    model: ProductModel,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(modifier = modifier.clickable {
        context.toProductDetail(model)
    }) {
        Thumbnail(
            id = model.id,
            imageUrl = model.imageUrl,
            name = model.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
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


@Preview(showBackground = true)
@Composable
private fun ProductPreview(@PreviewParameter(ProductParameterProvider::class) model: ProductModel) {
    ShoppingCartTheme {
        Product(model)
    }
}