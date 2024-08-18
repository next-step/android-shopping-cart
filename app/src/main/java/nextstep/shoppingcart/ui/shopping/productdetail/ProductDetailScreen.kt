package nextstep.shoppingcart.ui.shopping.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shopping.component.NavTopAppBar
import nextstep.shoppingcart.ui.shopping.model.dummyProducts
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.DividerColor
import nextstep.shoppingcart.ui.theme.ItemTextColor


@Composable
fun ProductDetailScreen(
    productId: Int,
    onClickNavigateBack: () -> Unit,
    onClickCartButton: () -> Unit
) {
    val product = remember {
        dummyProducts.find { it.id == productId }
    }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ProductDetailTopAppBar(onClickNavigateBack)
        },
        bottomBar = {
            CartButton(
                onClickCartButton = { onClickCartButton() },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues)
        ) {
            product?.let {
                ProductDetailInfo(
                    it.name,
                    it.imageUrl,
                    it.price
                )
            }
        }
    }
}

@Composable
fun ProductDetailTopAppBar(
    onClickNavigateBack: () -> Unit
) {
    NavTopAppBar(
        title = stringResource(id = R.string.product_detail),
        onClickNavigateBack = { onClickNavigateBack.invoke() }
    )
}

@Composable
fun ProductDetailInfo(
    name: String,
    imageUrl: String,
    price: Long
) {
    Column {
        DetailImage(imageUrl)
        DetailName(
            name = name,
            modifier = Modifier.padding(18.dp)
        )
        Divider(color = DividerColor)
        DetailPrice(
            price = price,
            modifier = Modifier.padding(18.dp)
        )
    }
}

@Composable
fun DetailImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.0f),
        placeholder = painterResource(id = R.drawable.ic_launcher_background)
    )
}

@Composable
fun DetailName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        color = ItemTextColor,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun DetailPrice(
    price: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.price),
            color = ItemTextColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = stringResource(id = R.string.item_price_format, price),
            color = ItemTextColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun CartButton(
    onClickCartButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClickCartButton.invoke() },
        modifier = modifier,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50
        ),
        contentPadding = PaddingValues(vertical = 15.dp)
    ) {
        Text(
            text = stringResource(id = R.string.put_shopping_cart),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPrev() {
    ProductDetailScreen(
        1,
        onClickNavigateBack = { },
        onClickCartButton = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarPrev() {
    ProductDetailTopAppBar(onClickNavigateBack = {})
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailInfoPrev() {
    ProductDetailInfo(
        name = "PET보틀-원형(500ml)",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 19_000_000L
    )
}

@Preview(showBackground = true)
@Composable
private fun DetailNamePrev() {
    DetailName(name = "이름")
}

@Preview(showBackground = true)
@Composable
private fun DetailPricePrev() {
    DetailPrice(price = 19_000_000L)
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartBtnPrev() {
    CartButton(
        onClickCartButton = {}
    )
}
