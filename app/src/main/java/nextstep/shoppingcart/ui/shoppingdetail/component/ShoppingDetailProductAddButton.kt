package nextstep.shoppingcart.ui.shoppingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.RobotoBold

@Composable
fun ShoppingDetailProductAddButton(
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingDetailAddButtonDescription =
        stringResource(id = R.string.shopping_detail_add_button_description)

    Button(
        onClick = onAddClick,
        shape = RoundedCornerShape(size = 0.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Blue),
    ) {
        Text(
            text = stringResource(id = R.string.shopping_detail_add_button),
            fontSize = 20.sp,
            fontFamily = RobotoBold,
            modifier = Modifier
                .padding(vertical = 14.dp)
                .semantics { contentDescription = shoppingDetailAddButtonDescription },
        )
    }
}

@Preview
@Composable
private fun ShoppingDetailProductAddButtonPreview() {
    ShoppingDetailProductAddButton(onAddClick = {})
}
