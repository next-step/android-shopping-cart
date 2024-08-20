package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.PRODUCT_LIST_MOCK_DATA
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductCard(
    product: Product,
    quantity: Int,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    onAddQuantityClick: () -> Unit = {},
    onRemoveQuantityClick: () -> Unit = {},
) {
    val isInCart = quantity > 0
    Column(
        modifier =
            modifier
                .clickable(onClick = onCardClick),
    ) {
        Box {
            ProductImage(
                imgUrl = product.imgUrl,
                contentDescription =
                    stringResource(
                        id = R.string.product_image_content_description,
                        product.name,
                    ),
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
            )

            /**
             * Mock data 이미지 배경이 하얀색이라서 경계가 보이지 않아서 별도로 border를 추가하였음
             */

            if (isInCart) {
                ElevatedCard(
                    onClick = { },
                    shape = RoundedCornerShape(4.dp),
                    modifier =
                        Modifier
                            .padding(horizontal = 15.dp, vertical = 12.dp)
                            .align(Alignment.BottomEnd),
                ) {
                    QuantitySelector(
                        quantity = quantity,
                        onAddClick = onAddQuantityClick,
                        onRemoveClick = onRemoveQuantityClick,
                        modifier = Modifier.background(Color.White),
                    )
                }
            } else {
                FloatingActionButton(
                    onClick = onAddToCartClick,
                    shape = CircleShape,
                    containerColor = Color.White,
                    modifier =
                        Modifier
                            .padding(12.dp)
                            .align(Alignment.BottomEnd)
                            .size(42.dp),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.add),
                        modifier = Modifier.size(24.dp),
                    )
                }
            }
        }
        ProductCardDescription(
            name = product.name,
            price = product.price,
        )
    }
}

@Composable
private fun ProductCardDescription(
    name: String,
    price: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            style =
                MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
            maxLines = 1,
            modifier =
                Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 2.dp,
                        start = 4.dp,
                    ),
        )
        Text(
            text = stringResource(id = R.string.product_price, price),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 4.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview(
    @PreviewParameter(ProductCardPreviewProvider::class) item: Pair<Product, Int>,
) {
    ShoppingCartTheme {
        ProductCard(
            product = item.first,
            quantity = item.second,
        )
    }
}

private val productMock = PRODUCT_LIST_MOCK_DATA.first()

class ProductCardPreviewProvider :
    CollectionPreviewParameterProvider<Pair<Product, Int>>(
        collection =
            listOf(
                productMock to 0,
                productMock.copy(
                    name = "행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다. 행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다",
                ) to 1,
            ),
    )
