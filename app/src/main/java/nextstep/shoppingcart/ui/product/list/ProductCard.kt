package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.PRODUCT_LIST_MOCK_DATA
import nextstep.shoppingcart.domain.model.ProductItem
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCard(
    item: ProductItem,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    onAddQuantityClick: () -> Unit = {},
    onRemoveQuantityClick: () -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .clickable(onClick = onCardClick),
    ) {
        Box {
            ProductImage(
                imgUrl = item.product.imgUrl,
                contentDescription =
                    stringResource(
                        id = R.string.product_image_content_description,
                        item.product.name,
                    ),
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
            )

            if (item.isInCart) {
                QuantitySelector(
                    quantity = item.quantity,
                    onAddClick = onAddQuantityClick,
                    onRemoveClick = onRemoveQuantityClick,
                    modifier =
                        Modifier
                            .padding(horizontal = 15.dp, vertical = 12.dp)
                            .align(Alignment.BottomEnd)
                            .clip(shape = RoundedCornerShape(4.dp))
                            .background(Color.White),
                )
            } else {
                /**
                 * Mock data 이미지 배경이 하얀색이라서 +버튼의 경계가 보이지 않아서 별도로 border를 추가하였음
                 */
                AddToCartButton(
                    onClick = onAddToCartClick,
                    modifier =
                        Modifier
                            .padding(12.dp)
                            .align(Alignment.BottomEnd)
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = CircleShape,
                            ).size(42.dp)
                            .testTag(stringResource(id = R.string.test_tag_product_cart_add)),
                )
            }
        }
        ProductCardDescription(
            name = item.product.name,
            price = item.product.price,
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

@Composable
private fun AddToCartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        colors =
            IconButtonDefaults.iconButtonColors(
                containerColor = Color.White,
            ),
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add),
            modifier = Modifier.size(24.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview(
    @PreviewParameter(ProductCardPreviewProvider::class) item: ProductItem,
) {
    ShoppingCartTheme {
        ProductCard(
            item = item,
        )
    }
}

class ProductCardPreviewProvider :
    CollectionPreviewParameterProvider<ProductItem>(
        collection =
            PRODUCT_LIST_MOCK_DATA
                .take(3)
                .mapIndexed { index, product ->
                    ProductItem(
                        product =
                            if (index == 2) {
                                product.copy(
                                    name = "행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다. 행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다",
                                )
                            } else {
                                product
                            },
                        isInCart = index > 0,
                        quantity = index,
                    )
                },
    )
