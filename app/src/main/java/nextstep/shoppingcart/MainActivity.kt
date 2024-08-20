package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ShoppingItemView
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listOfItems = listOf(
            Product(name = "name", price = 10000, description = "description"),
            Product(name = "name2", price = 15000, description = "description"),
            Product(name = "name3", price = 12000, description = "description"),
            Product(name = "name4", price = 9000, description = "description"),
            Product(name = "name5", price = 5500, description = "description"),
            Product(name = "name6", price = 125000, description = "description"),
            Product(name = "name7", price = 9900, description = "description"),
            Product(name = "name8", price = 52000, description = "description")
        )
        setContent {
            ShoppingCartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = stringResource(id = R.string.product_list),
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                },
                                actions = {
                                    Icon(Icons.Filled.ShoppingCart, contentDescription = stringResource(id = R.string.app_name))
                                }
                            )
                        },
                        content = { padding ->
                            LazyVerticalGrid(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(padding),
                                columns = GridCells.Fixed(2),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                items(listOfItems) { item ->
                                    ShoppingItemView(item)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingCartTheme {
        Greeting("Android")
    }
}
