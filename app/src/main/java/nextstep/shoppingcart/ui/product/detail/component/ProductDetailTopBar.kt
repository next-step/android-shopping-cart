package nextstep.shoppingcart.ui.product.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailTopBar(modifier: Modifier = Modifier, onClickBackIcon: () -> Unit) {
    TopAppBar(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth(),
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_product_detail_title),
                textAlign = TextAlign.Left
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onClickBackIcon
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.text_back_Icon_description)
                )
            }
        }
    )
}

@Preview
@Composable
private fun ProductDetailTopBarPreview() {
    ProductDetailTopBar(Modifier, {})
}