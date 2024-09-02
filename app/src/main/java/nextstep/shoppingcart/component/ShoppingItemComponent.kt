package nextstep.shoppingcart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

const val SHOPPING_ITEM_WIDTH = 156

@Composable
fun ShoppingItemComponent(
    product: Product,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Box(
            modifier = Modifier
        ){
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop
            )
            AddButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onClick = {

                }
            )

        }

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 2.dp, start = 4.dp, end = 23.dp),
            text = product.name,
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 16.sp
            ),
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier.padding(start = 4.dp, end = 23.dp),
            text = stringResource(id = R.string.shopping_list_price_korean,product.price),
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 20.sp
            )
        )
    }
}

@Composable
fun AddButton(
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Image(
            imageVector = Icons.Default.Add, contentDescription = "")
    }
}

@Preview(showBackground = true, name = "ShoppingItemComponent")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingItemComponent(
            modifier = Modifier.width(200.dp),
            product = Product(
                imageUrl = "https://picsum.photos/id/0/5000/3333",
                name = "신형 노트북",
                price = 2_000_000,
                id = 1
            ),
            onClick = {

            }
        )
    }

}

@Preview(showBackground = true, name = "AddButton")
@Composable
private fun Preview2() {
    ShoppingCartTheme {
        AddButton(
            onClick = {}
        )
    }

}