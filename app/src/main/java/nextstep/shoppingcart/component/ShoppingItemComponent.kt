package nextstep.shoppingcart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Cart


@Composable
fun ShoppingItemComponent(
    product: Product,
    count : Int,
    onPlusClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Box(
            modifier = Modifier
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop
            )
            if(count >= 1){
                CounterCard(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(20.dp),
                    onPlusClick = {
                        if(count < 99) onPlusClick(product)
                    },
                    onMinusClick = {
                        onMinusClick(product)
                    },
                    count = count
                )
            }else {
                AddButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp),
                    onClick = {
                        onPlusClick(product)
                    }
                )
            }


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
            text = stringResource(id = R.string.shopping_list_price_korean, product.price),
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 20.sp
            )
        )
    }
}

@Composable
fun AddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier.testTag("AddButton"),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Image(
            imageVector = Icons.Default.Add, contentDescription = ""
        )
    }
}

@Composable
fun CounterCard(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .testTag("CounterCard")
            .clip(RoundedCornerShape(4.dp))
            .aspectRatio(3f)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CounterButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            text = "-",
            onClick = onMinusClick
        )

        Text(
            modifier = Modifier.weight(1f).testTag("CounterCardText"),
            text = "$count",
            fontSize = 22.sp,
            fontWeight = FontWeight(400),
            textAlign = TextAlign.Center
        )
        CounterButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            text = "+",
            onClick = onPlusClick
        )
    }
}

@Composable
fun CounterButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
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
            onClick = {},
            onMinusClick = {},
            onPlusClick = {},
            count = 1
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

@Preview(showBackground = true, name = "QuantityCounterCard")
@Composable
private fun Preview3() {
    ShoppingCartTheme {
        CounterCard(
            modifier = Modifier.width(126.dp),
            count = 1,
            onMinusClick = {},
            onPlusClick = {}
        )
    }
}

@Preview(showBackground = true, name = "QuantityCounterCardWithInteraction")
@Composable
private fun Preview4() {
    var count by remember {
        mutableStateOf(1)
    }
    ShoppingCartTheme {
        CounterCard(
            modifier = Modifier.width(126.dp),
            count = count,
            onMinusClick = { if (count > 1) count--},
            onPlusClick = {  count++  }
        )
    }
}

@Preview(showBackground = true, name = "ShoppingItemComponentCountEquals1")
@Composable
private fun Preview5() {
    ShoppingCartTheme {
        ShoppingItemComponent(
            modifier = Modifier.width(200.dp),
            product = Product(
                imageUrl = "https://picsum.photos/id/0/5000/3333",
                name = "신형 노트북",
                price = 2_000_000,
                id = 1
            ),
            onClick = {},
            onMinusClick = {},
            onPlusClick = {},
            count = 1
        )
    }
}

@Preview(showBackground = true, name = "ShoppingItemComponentCountEquals0")
@Composable
private fun Preview6() {
    ShoppingCartTheme {
        ShoppingItemComponent(
            modifier = Modifier.width(200.dp),
            product = Product(
                imageUrl = "https://picsum.photos/id/0/5000/3333",
                name = "신형 노트북",
                price = 2_000_000,
                id = 1
            ),
            onClick = {},
            onMinusClick = {},
            onPlusClick = {},
            count = 0
        )
    }
}

@Preview(showBackground = true, name = "ShoppingItemComponentCountEquals99")
@Composable
private fun Preview7() {
    ShoppingCartTheme {
        ShoppingItemComponent(
            modifier = Modifier.width(200.dp),
            product = Product(
                imageUrl = "https://picsum.photos/id/0/5000/3333",
                name = "신형 노트북",
                price = 2_000_000,
                id = 1
            ),
            onClick = {},
            onMinusClick = {},
            onPlusClick = {},
            count = 99
        )
    }
}