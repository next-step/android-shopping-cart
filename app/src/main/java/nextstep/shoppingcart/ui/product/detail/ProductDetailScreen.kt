package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.data.ProductsImpl
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.theme.Blue50

@Composable
internal fun ProductDetailRoute(
    productId: Long,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val products: Products = remember { ProductsImpl() }
    val product = products.findById(productId) ?: return

    ProductDetailScreen(
        product = product,
        navigateUp = { navController.popBackStack() },
        modifier = modifier.fillMaxSize(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductDetailScreen(
    product: Product,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.product_detail_toolbar_title))
                },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_back),
                        )
                    }
                },
            )
        },
        modifier = modifier,
    ) { paddingValues ->
        ProductDetailContent(
            product = product,
            modifier =
                modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
        )
    }
}

@Composable
private fun ProductDetailContent(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            ProductImage(
                imgUrl = product.imgUrl,
                contentDescription =
                    stringResource(
                        id = R.string.product_image_content_description,
                        product.name,
                    ),
                placeholder = painterResource(id = R.drawable.image),
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = product.name,
                overflow = TextOverflow.Ellipsis,
                style =
                    MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                    ),
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 18.dp),
            )
            Divider(modifier = Modifier.height(1.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 18.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.product_detail_price_title),
                    style =
                        MaterialTheme.typography.titleMedium.copy(
                            fontSize = 20.sp,
                        ),
                )
                Text(
                    text = stringResource(id = R.string.product_price, product.price),
                    style =
                        MaterialTheme.typography.titleMedium.copy(
                            fontSize = 20.sp,
                        ),
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Blue50,
                    contentColor = Color.White,
                ),
            shape = RectangleShape,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(54.dp),
        ) {
            Text(
                text = stringResource(id = R.string.product_detail_btn_title),
                style =
                    MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    ),
            )
        }
    }
}
