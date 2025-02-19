package nextstep.shoppingcart.ui.list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.annotation.BackgroundPreview
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.designsystem.component.ProductAmount
import nextstep.shoppingcart.designsystem.component.ProductImage
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.model.Product

@Composable
fun ProductImageContainer(
    item: Product,
    count: Int,
    modifier: Modifier = Modifier,
    onAdd: (Product) -> Unit = {},
    onRemove: (Product) -> Unit = {}
) {

    Box(modifier = modifier) {
        ProductImage(
            item = item,
            modifier = Modifier.aspectRatio(1f)
        )
        if (count > 0) {
            ProductAmount(
                item = item,
                count = count,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 12.dp, start = 15.dp, end = 15.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(4.dp)
                    ),
                onAdd = onAdd,
                onRemove = onRemove
            )
        } else {
            IconButton(
                onClick = { onAdd(item) },
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomEnd)
                    .background(color = Color.White, CircleShape)
            ) {
                Icon(Icons.Default.Add, contentDescription = "${item.id}_add")
            }
        }
    }
}


@BackgroundPreview
@Composable
private fun ProductImageContainerPreview() {
    ShoppingCartTheme {
        ProductImageContainer(item = mockProducts[0], count = 1)
    }
}