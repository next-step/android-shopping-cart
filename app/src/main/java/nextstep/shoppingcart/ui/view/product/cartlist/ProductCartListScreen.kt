package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCartListScreen(modifier: Modifier = Modifier) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(vertical = 4.dp),
                navigationIcon = {
                    Image(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable { onBackPressedDispatcher?.onBackPressed() }
                            .padding(10.dp),
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.navigation_back)
                    )
                },
                title = {
                    Text(text = stringResource(R.string.product_cart_list_title))
                },
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}

@Preview
@Composable
private fun ProductCartListScreenPreview() {
    ProductCartListScreen()
}
