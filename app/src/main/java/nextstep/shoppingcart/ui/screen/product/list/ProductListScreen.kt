package nextstep.shoppingcart.ui.screen.product.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    productItems: List<Product>,
    onClickCart: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(onClick = onClickCart) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "장바구니"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(paddingValues = innerPadding),
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(vertical = 13.dp, horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 12.dp)
        ) {
            items(items = productItems) { item ->
                Column(modifier = Modifier.clickable { }) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(ratio = 1f),
                            model = item.imageUrl,
                            contentDescription = null,
                            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            modifier = Modifier
                                .padding(end = 12.dp, bottom = 12.dp)
                                .size(size = 42.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color.White)
                                .clickable {  }
                                .padding(all = 9.dp),
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                        )
                    }
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = item.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        text = stringResource(id = R.string.price, item.price)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ProductListScreen(
        productItems = Product.fixture,
        onClickCart = {}
    )
}
