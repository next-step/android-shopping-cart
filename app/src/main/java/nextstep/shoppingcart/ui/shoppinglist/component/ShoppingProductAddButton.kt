package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R.string.shopping_product_add_button
import nextstep.shoppingcart.R.string.shopping_product_add_button_description

@Composable
fun ShoppingProductAddButton(
    onAddButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingProductAddButtonDescription =
        stringResource(id = shopping_product_add_button_description)
    val shoppingProductAddButton = stringResource(id = shopping_product_add_button)

    Button(
        onClick = onAddButton,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.White,
        ),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier
            .size(42.dp)
            .semantics { contentDescription = shoppingProductAddButtonDescription },
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = shoppingProductAddButton,
        )
    }
}

@Preview
@Composable
private fun ShoppingProductAddButtonPreview() {
    ShoppingProductAddButton(
        onAddButton = {},
    )
}
