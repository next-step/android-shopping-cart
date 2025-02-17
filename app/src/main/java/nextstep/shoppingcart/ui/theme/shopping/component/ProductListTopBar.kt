package nextstep.shoppingcart.ui.theme.shopping.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListTopBar(
    topBarTitle: String,
    modifier: Modifier = Modifier,
    leftIcon: ImageVector? = null,
    leftIconContentDescription: String = "",
    rightIcon: ImageVector? = null,
    rightIconContentDescription: String = "",
    onLeftIconClicked: () -> Unit = {},
    onRightIconClicked: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = topBarTitle,
            fontSize = 22.sp,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
        leftIcon?.let { leftIcon ->
            Icon(
                imageVector = leftIcon,
                contentDescription = leftIconContentDescription,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable {
                        onLeftIconClicked()
                    }
            )
        }
        rightIcon?.let { rightIcon ->
            Icon(
                imageVector = rightIcon, contentDescription = rightIconContentDescription,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable {
                        onRightIconClicked()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListTopBarPreview() {
    ShoppingCartTheme {
        ProductListTopBar(topBarTitle = "상품 목록", rightIcon = Icons.Filled.ShoppingCart)
    }
}
