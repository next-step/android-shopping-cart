package nextstep.shoppingcart.ui.screen.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun ProductContainer(
    title: String,
    price: Int,
    count: Int,
    imageUrl: String,
    isQuantityAdjusting: Boolean,
    modifier: Modifier = Modifier,
    onPlusCircleClick: () -> Unit,
    onMinusCartItemClick: () -> Unit,
    onPlusCartItemClick: () -> Unit,
) {

    Column(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
        ) {
            ProductImage(
                imageUrl = imageUrl,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(78f / 79f)
            )
            AnimatedQuantityAdjustContainer(
                isQuantityAdjusting = isQuantityAdjusting,
                count = count,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onPlusCircleClick = onPlusCircleClick,
                onMinusCartItemClick = onMinusCartItemClick,
                onPlusCartItemClick = onPlusCartItemClick
            )
        }
        ProductInfo(
            title = title,
            price = price,
        )
    }
}

@Composable
private fun AnimatedQuantityAdjustContainer(
    isQuantityAdjusting: Boolean,
    count: Int,
    modifier: Modifier = Modifier,
    onPlusCircleClick: () -> Unit,
    onMinusCartItemClick: () -> Unit,
    onPlusCartItemClick: () -> Unit,
) {
    AnimatedContent(
        targetState = isQuantityAdjusting,
        label = stringResource(id = R.string.quantity_toggle),
        modifier = modifier
    ) { isAdjusting ->
        if (isAdjusting) {
            QuantityAdjustContainer(
                count = count,
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(Color.White),
                onMinusCartItemClick = onMinusCartItemClick,
                onPlusCartItemClick = onPlusCartItemClick
            )
        } else {
            PlusFloatButton(
                modifier = Modifier.size(42.dp),
                onClick = onPlusCircleClick
            )
        }
    }
}

@Composable
private fun PlusFloatButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = Color.White,
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Plus",
            tint = Color.Black,
        )
    }
}

@Composable
private fun ProductInfo(
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
        )
        PriceText(price = price)
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimatedQuantityAdjustContainerPreview() {
    AnimatedQuantityAdjustContainer(
        count = 2,
        isQuantityAdjusting = true,
        onPlusCircleClick = { },
        onMinusCartItemClick = { },
        onPlusCartItemClick = { },
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusFloatButtonPreview() {
    PlusFloatButton(
        onClick = { },
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductInfoPreview() {
    ProductInfo(
        title = "상품 이름",
        price = 10000,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductItemContainerPreview() {
    ProductContainer(
        title = "상품 이름",
        price = 10000,
        count = 2,
        imageUrl = "https://www.picsum.photos/200",
        isQuantityAdjusting = false,
        onPlusCircleClick = { },
        onMinusCartItemClick = { },
        onPlusCartItemClick = { },
    )
}