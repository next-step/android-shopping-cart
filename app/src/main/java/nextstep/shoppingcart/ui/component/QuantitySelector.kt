package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun QuantitySelector(
    quantity: Int,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        IconButton(
            onClick = onRemoveClick,
            modifier =
                Modifier
                    .weight(1f)
                    .testTag(stringResource(id = R.string.test_tag_quantity_selector_remove)),
        ) {
            Text(
                text = stringResource(id = R.string.remove),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            text = "$quantity",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            modifier =
                Modifier
                    .weight(1f)
                    .testTag(stringResource(id = R.string.test_tag_quantity_selector_quantity)),
        )

        IconButton(
            onClick = onAddClick,
            modifier =
                Modifier
                    .weight(1f)
                    .testTag(stringResource(id = R.string.test_tag_quantity_selector_add)),
        ) {
            Text(
                text = stringResource(id = R.string.add),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantitySelectorPreview() {
    ShoppingCartTheme {
        var quantity by
            remember {
                mutableIntStateOf(1)
            }
        QuantitySelector(
            quantity = quantity,
            onAddClick = {
                quantity++
            },
            onRemoveClick = {
                if (quantity > 0) {
                    quantity--
                }
            },
        )
    }
}
