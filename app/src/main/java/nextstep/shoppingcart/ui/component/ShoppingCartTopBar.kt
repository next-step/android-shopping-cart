package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.ShoppingCartTopBarType
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartTopBar(
    type: ShoppingCartTopBarType,
    modifier: Modifier = Modifier,
    onClickCart: (() -> Unit)? = null,
    onClickBack: (() -> Unit)? = null,
) {
    with(type) {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = stringResource(titleResId),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = if (isCenter) TextAlign.Center else TextAlign.Start
                )
            },
            actions = {
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    if (showCartIcon) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(R.string.cart),
                        )
                    }
                }
            },
            navigationIcon = {
                Box(
                    modifier = Modifier.size(40.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    if (showBackButton) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingCartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ShoppingCartTopBarType.entries.forEach {
                ShoppingCartTopBar(
                    type = it
                )
            }
        }
    }
}