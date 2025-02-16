package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun CartScreen(
    onClickBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            CartTopBar(
                onClickBack = onClickBack
            )
        }
    ) { paddingValues ->
        CartContent(
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CartTopBar(
    onClickBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.cart_top_bar_title),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
            }
        }
    )
}

@Composable
private fun CartContent(
    modifier: Modifier = Modifier,
) {

}