package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartTopBar(
    titleResId: Int,
    isCenter: Boolean,
    modifier: Modifier = Modifier,
    onClickCart: (() -> Unit)? = null,
    onClickBack: (() -> Unit)? = null,
) {
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
            TopBarIcon(
                onClick = onClickCart,
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = stringResource(R.string.cart)
            )
        },
        navigationIcon = {
            TopBarIcon(
                onClick = onClickBack,
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back)
            )
        }
    )
}

@Composable
private fun TopBarIcon(
    onClick: (() -> Unit)?,
    imageVector: ImageVector,
    contentDescription: String,
) {
    Box(
        modifier = Modifier.size(40.dp),
        contentAlignment = Alignment.Center,
    ) {
        onClick?.let {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                modifier = Modifier.clickable { it.invoke() }
            )
        }
    }
}


@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingCartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ShoppingCartTopBar(
                titleResId = R.string.product_list,
                isCenter = true,
                onClickCart = {}
            )
        }
    }
}