package nextstep.shoppingcart.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.DefaultNavigationBackTopBar

@Composable
fun ProductDetailScreen(
    product: Product,
    onClickBack: () -> Unit,
    onClickAddToCart: () -> Unit
) {
    Scaffold(
        topBar = {
            DefaultNavigationBackTopBar(
                title = stringResource(id = R.string.product_detail_top_bar_title),
                onClickBack = onClickBack
            )
        }
    ) { paddingValues ->
        ProductDetailContent(
            product = product,
            onClickAddToCart = onClickAddToCart,
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
private fun ProductDetailContent(
    product: Product,
    onClickAddToCart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "product image",
            modifier = Modifier.aspectRatio(1f)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 18.dp)
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 18.dp)
        )

        Row(
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            Text(
                text = stringResource(id = R.string.product_detail_price),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = product.formattedPrice,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(id = R.string.product_detail_cart_button),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {
                    onClickAddToCart()
                }
        )
    }
}

@Preview
@Composable
private fun ProductDetailContentPreview() {
    ProductDetailContent(
        product = Product.mock,
        onClickAddToCart = { }
    )
}