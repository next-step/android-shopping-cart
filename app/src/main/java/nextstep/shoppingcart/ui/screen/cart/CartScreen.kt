package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CartScreen(onClickBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.cart)) },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.go_back),
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            Text(
                modifier = Modifier.padding(innerPadding),
                text = stringResource(id = R.string.cart)
            )
        },
    )
}
