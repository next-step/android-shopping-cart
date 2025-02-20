package nextstep.shoppingcart.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartFloatingActionButton(
    buttonType: ShoppingCartFloatingActionButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    contentColor: Color = Color.Black,
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = containerColor,
        contentColor = contentColor,
        shape = CircleShape,
        modifier = modifier,
    ) {
        Icon(
            imageVector = buttonType.imageVector,
            contentDescription = stringResource(buttonType.contentDescription),
        )
    }
}

enum class ShoppingCartFloatingActionButtonType(
    val imageVector: ImageVector,
    @StringRes val contentDescription: Int,
) {
    ADD(
        Icons.Filled.Add,
        R.string.floating_action_button_type_add_description,
    ),
}

@Preview
@Composable
private fun ShoppingCartFloatingActionButtonPreview() {
    ShoppingCartTheme {
        ShoppingCartFloatingActionButton(
            buttonType = ShoppingCartFloatingActionButtonType.ADD,
            onClick = {},
        )
    }
}
