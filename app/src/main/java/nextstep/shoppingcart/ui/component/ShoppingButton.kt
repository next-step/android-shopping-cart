package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R.string.shopping_button
import nextstep.shoppingcart.ui.theme.RobotoBold

@Composable
fun ShoppingButton(
    onClick: () -> Unit,
    buttonTitle: String,
    modifier: Modifier = Modifier,
) {
    val shoppingDetailAddButtonDescription = stringResource(id = shopping_button)

    Button(
        onClick = onClick,
        shape = RectangleShape,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Blue),
    ) {
        Text(
            text = buttonTitle,
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
    ShoppingButton(
        onClick = {},
        buttonTitle = "테스트",
    )
}
