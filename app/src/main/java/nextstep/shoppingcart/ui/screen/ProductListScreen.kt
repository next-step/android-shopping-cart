package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.data.Product
import nextstep.shoppingcart.ui.data.SampleProductList.sampleProductList
import java.text.DecimalFormat


@Composable
fun ProductListScreen(productList: List<Product>) {
    Scaffold(

    ) { innerPadding ->
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 32.sp,
                    text = stringResource(id = R.string.text_product_list_title)
                )

                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.text_shopping_cart_Icon_description),
                    modifier = Modifier
                        .size(24.dp)
                        .align(AbsoluteAlignment.CenterRight)
                )
            }
            ProductLazeColum(productList)
        }
    }
}

@Composable
fun ProductView(product: Product) {
    Column(
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
            text = "${DecimalFormat("#,###").format(product.price)}원"
        )
    }
}

@Composable
fun ProductLazeColum(productList: List<Product>) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState()
    ) {

        items(productList) { product ->
            ProductView(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(sampleProductList)
}

@Preview(showBackground = true)
@Composable
private fun ProductLazeColumPreview() {
    ProductLazeColum(sampleProductList)
}

