package nextstep.shoppingcart.ui.productList.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.data.Product

@Composable
fun ProductCard(product: Product, onClickCard: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClickCard)
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = product.imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(vertical = 3.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = product.name
        )

        Text(
            modifier = Modifier,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyMedium,
            text = stringResource(id = R.string.formatted_price, product.price)
        )
    }
}