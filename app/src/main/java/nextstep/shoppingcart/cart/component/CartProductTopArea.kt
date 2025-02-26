package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartProductTopArea(
    name: String,
    onRemoveCart: () -> Unit,
    rightIcon: ImageVector,
    rightIconContentDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(0.8f)
        )
        Icon(
            imageVector = rightIcon,
            contentDescription = rightIconContentDescription,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onRemoveCart()
                },

            )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductTitlePreview() {
    ShoppingCartTheme {
        CartProductTopArea(
            "[든든] 동원 스위트콘 스위트콘스위트콘 스위트콘스위트콘스위트콘스위트콘", {}, rightIcon = Icons.Filled.Clear,
            rightIconContentDescription = "삭제버튼",
        )
    }
}
