package nextstep.shoppingcart.component.topbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCenterAlignedTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    colors : TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = Color.White
    ),
    leftActionButtons: @Composable () -> Unit = {},
    rightActionButtons: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            leftActionButtons()
        },
        actions = {
            rightActionButtons()
        },
        colors = colors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "ShoppingTopBarWithBack")
@Composable
private fun Preview1() {
    ShoppingCenterAlignedTopBar(
        modifier = Modifier,
        title = "title",
        leftActionButtons = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "ShoppingTopBarWithCart")
@Composable
private fun Preview2() {
    ShoppingCenterAlignedTopBar(
        modifier = Modifier,
        title = "title",
        rightActionButtons = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "ShoppingCart"
                )
            }
        }
    )
}

