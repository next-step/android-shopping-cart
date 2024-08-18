package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.SampleProductList.sampleProductList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartCard(modifier: Modifier = Modifier, product: Product) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = product.name,
                    textAlign = TextAlign.Left
                )
            }, actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.text_close_Icon_description)
                    )
                }
            })
        }, modifier = modifier
    ) { paddingValue ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValue)
        ) {
            AsyncImage(
                modifier = modifier.weight(1f),
                model = product.imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Black)
            )

            PriceQuantityInfo(
                modifier = Modifier.weight(1f),
                product = product
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 220
)
@Composable
private fun CartCardPreview() {
    CartCard(
        modifier = Modifier, product = sampleProductList[2]
    )
}

