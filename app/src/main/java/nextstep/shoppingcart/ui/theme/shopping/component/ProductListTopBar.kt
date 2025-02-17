package nextstep.shoppingcart.ui.theme.shopping.component

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopBar(
    topBarTitle: String,
    leftIcon: ImageVector? = null,
    leftIconContentDescription: String = "",
    onLeftIconClicked: () -> Unit = {},
    rightIcon: ImageVector? = null,
    rightIconContentDescription: String = "",
    onRightIconClicked: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = topBarTitle,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            leftIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = leftIconContentDescription,
                    modifier = Modifier
                        .clickable {
                            onLeftIconClicked()
                        }
                )
            }
        },
        actions = {
            rightIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = rightIconContentDescription,
                    modifier = Modifier
                        .clickable {
                            onRightIconClicked()
                        }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListTopBarPreview() {
    ShoppingCartTheme {
        ProductListTopBar(topBarTitle = "상품 목록", rightIcon = Icons.Filled.ShoppingCart)
    }
}
