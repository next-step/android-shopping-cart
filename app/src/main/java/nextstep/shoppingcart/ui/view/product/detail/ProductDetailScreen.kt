package nextstep.shoppingcart.ui.view.product.detail

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.InvalidAccessItem
import nextstep.shoppingcart.ui.model.Cart
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.view.product.cartlist.ProductCartListActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product?,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(vertical = 4.dp),
                navigationIcon = {
                    Image(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { onBackPressedDispatcher?.onBackPressed() }
                            .padding(10.dp),
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.navigation_back)
                    )
                },
                title = {
                    Text(text = stringResource(R.string.product_detail_title))
                },
            )
        }
    ) { paddingValues ->
        if (product == null) {
            InvalidAccessItem(modifier = Modifier.padding(paddingValues))
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        model = product.imageUrl,
                        contentDescription = stringResource(R.string.product_detail_product_image)
                    )
                    Text(
                        modifier = Modifier.padding(18.dp),
                        text = product.name,
                        fontWeight = FontWeight.W700,
                        fontSize = 24.sp,
                        color = Color(0xff333333)
                    )
                    Divider(
                        thickness = Dp.Hairline,
                        color = Color(0xffaaaaaa)
                    )
                    Row(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = "금액",
                            fontWeight = FontWeight.W400,
                            fontSize = 20.sp,
                            color = Color(0xff333333)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = stringResource(id = R.string.product_list_product_item_price_fmt, product.price),
                            fontWeight = FontWeight.W400,
                            fontSize = 20.sp,
                            color = Color(0xff333333)
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    shape = RectangleShape,
                    contentPadding = PaddingValues(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xff2196F3)
                    ),
                    onClick = {
                        Cart.addOne(product)
                        context.startActivity(ProductCartListActivity.newIntent(context))
                    }
                ) {
                    Text(
                        text = stringResource(R.string.product_detail_put_in_shopping_cart_button),
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreviewProductNull() {
    ProductDetailScreen(product = null)
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            name = "Product Name",
            price = 10000,
            imageUrl = "https://example.com/image.jpg"
        )
    )
}
