package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ProductBottomBar
import nextstep.shoppingcart.ui.component.ProductDetailTopBar
import nextstep.shoppingcart.ui.data.Product

@Composable
fun ProductDetailScreen(modifier: Modifier, product: Product) {
    Scaffold(
        topBar = {
            ProductDetailTopBar(modifier)
        },
        bottomBar = {
            ProductBottomBar()
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            AsyncImage(
                modifier = Modifier.height(360.dp),
                model = product.imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Black)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                text = product.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                thickness = 1.dp
            )

            Row(
                modifier
                    .padding(18.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.text_price),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Start,
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.formatted_price, product.price),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        Modifier, Product(
            id = 9170,
            imgUrl = "https://duckduckgo.com/?q=constituto",
            name = "Ernie Santana",
            price = 1590
        )
    )
}