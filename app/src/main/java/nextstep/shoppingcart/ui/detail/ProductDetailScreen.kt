package nextstep.shoppingcart.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.Blue50
import nextstep.shoppingcart.designsystem.theme.DividerColor
import nextstep.shoppingcart.designsystem.theme.TextColor
import nextstep.shoppingcart.designsystem.theme.TopBarTextColor
import nextstep.shoppingcart.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    item: Product,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.product_detail_title),
                        fontSize = 22.sp,
                        color = TopBarTextColor,
                    )
                },
                navigationIcon = {
                    Image(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back_icon",
                        modifier = Modifier
                            .clickable { onBack() }
                            .size(40.dp)
                            .padding(8.dp)
                    )
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = item.imageUrl,
                contentDescription = "product_image",
                contentScale = ContentScale.Crop
            )

            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp),
                color = TextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = DividerColor
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.price_content),
                    fontSize = 20.sp,
                    color = TextColor
                )
                Text(
                    text = stringResource(R.string.price, item.price),
                    fontSize = 20.sp,
                    color = TextColor
                )
            }

            Spacer(Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Blue50),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.cart_content),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    val item = Product(
        id = 1,
        name = "PET-보틀-정사각형정사각형정사각형정사각형1",
        price = 10000,
        imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
    )
    ProductDetailScreen(item = item)
}