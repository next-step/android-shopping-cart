package nextstep.shoppingcart.ui.component

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth(),
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_product_list_title),
                textAlign = TextAlign.Center
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = stringResource(id = R.string.text_shopping_cart_Icon_description)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailTopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_product_detail_title),
                textAlign = TextAlign.Left
            )
        },
        navigationIcon = {
            IconButton(onClick = { (context as? Activity)?.finish() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.text_back_Icon_description)
                )
            }
        }
    )
}

@Composable
fun ProductBottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier
            .fillMaxWidth(),
        containerColor = Color(0xFF2196F3)
    ) {
        Text(
            text = stringResource(id = R.string.text_shopping_cart),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
