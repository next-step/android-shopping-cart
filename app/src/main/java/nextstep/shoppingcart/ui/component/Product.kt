package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.screen.products.model.ProductModel
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun Product(
    productModel: ProductModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .width(156.dp)
                .height(158.dp),
            model = productModel.imageUrl,
            contentDescription = stringResource(R.string.product_image_description, productModel.name),
            placeholder = painterResource(id = R.drawable.ic_launcher_background)
        )
        Text(
            text = productModel.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(R.string.product_price, productModel.price),
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        Product(
            ProductModel(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000
            )
        )
    }
}
