package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@Composable
fun AddToCartIcon(
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = {
            onPlusClick()
        },
        modifier = Modifier
            .clip(CircleShape)
            .background(color = Color.White)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_to_cart)
        )
    }
}

@Preview
@Composable
private fun AddToCartIconPreview() {
    AddToCartIcon(onPlusClick = { })
}