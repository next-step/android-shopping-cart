package nextstep.shoppingcart.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.goods.impl.ProductRepositoryImpl
import nextstep.shoppingcart.ui.ShoppingCartDestinations
import nextstep.shoppingcart.ui.component.ShoppingTopBar

@Composable
fun ProductDetail(
    navController: NavController,
    productId: Int
) {
    Scaffold(
        topBar = {
            ShoppingTopBar(navController)
        }, bottomBar = {
            ProductBottomBar(navController)
        }
    ) { paddingValues ->
        val productRepository = ProductRepositoryImpl()
        val product = productRepository.getProduct(productId) ?: return@Scaffold
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f) // 1:1 비율로 설정, 필요에 따라 조정 가능

            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(horizontal = 18.dp)
                )
            }
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "금액",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "%,d원".format(product.price),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

@Composable
private fun ProductBottomBar(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(ShoppingCartDestinations.SHOPPING_CART)
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3),
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RectangleShape,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = "장바구니 담기",
            style = MaterialTheme.typography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun ProductDetailPreview() {
    ProductDetail(rememberNavController(), 1)
}

@Preview
@Composable
private fun ProductBottomBarPreview() {
    ProductBottomBar(navController = rememberNavController())
    
}