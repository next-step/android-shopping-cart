package nextstep.shoppingcart.ui.component

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.ui.component.preview.ProductParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun Product(
    model: ProductModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Thumbnail(
            id = model.id,
            imageUrl = model.imageUrl,
            name = model.name
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
        Text(
            text = stringResource(R.string.korean_price_format, model.price),
            style = Typography.bodyMedium,
            maxLines = 1,
            modifier = Modifier
                .heightIn(min = 20.dp)
                .padding(horizontal = 4.dp),
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun Thumbnail(id: Long, imageUrl: String, name: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .diskCacheKey(id.toString())
            .build(),
        contentDescription = stringResource(
            R.string.product_image_accessibility_text,
            name,
        ),
        contentScale = ContentScale.FillHeight,
        error = painterResource(R.drawable.ic_connection_error),
        placeholder = painterResource(R.drawable.loading_img),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview(@PreviewParameter(ProductParameterProvider::class) model: ProductModel) {
    ShoppingCartTheme {
        Product(model)
    }
}