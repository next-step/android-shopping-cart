package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ShoppingTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "상품 상세",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}