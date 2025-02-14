package nextstep.shoppingcart.ui

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import nextstep.shoppingcart.ui.component.Thumbnail
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun ProductDetailScreen(
    model: ProductModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()) {
        ShoppingCartTopBar(
            titleResId = R.string.product_detail,
            isCenter = false,
            onClickBack = {},
        )
        Thumbnail(
            id = model.id,
            imageUrl = model.imageUrl,
            name = model.name,
        )
        Text(
            text = model.name,
            style = Typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(18.dp),
        )
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFAAAAAA))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(R.string.price),
                style = Typography.bodyLarge,
            )
            Text(
                text = stringResource(R.string.korean_price_format, model.price),
                style = Typography.bodyLarge,
            )
        }

        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 8.dp),
                onClick = {},
                shape = RectangleShape,
            ) {
                Text(
                    text = stringResource(R.string.add_cart),
                    style = Typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            model = ProductModel(id = 7984L, imageUrl = "Adan", name = "Carina", price = 8399)
        )
    }
}