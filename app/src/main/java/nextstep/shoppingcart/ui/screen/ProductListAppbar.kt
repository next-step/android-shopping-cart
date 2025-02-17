package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.BlackDark
import nextstep.shoppingcart.ui.theme.White
import nextstep.signup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListAppBar(
    title: String,
    actionIconOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val descriptionNavigate = stringResource(R.string.description_shopping_cart_navigate)

    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = modifier,
        navigationIcon = {
            Spacer(modifier = modifier.size(48.dp))
        },
        actions = {
            IconButton(
                onClick = actionIconOnClick
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = descriptionNavigate,
                    modifier = modifier
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = BlackDark,
        ),
    )
}

@Preview
@Composable
fun ProductListAppBarPreview() {
    ProductListAppBar(
        title = "앱바 제목 1234567890123456789",
        actionIconOnClick = { },
    )
}