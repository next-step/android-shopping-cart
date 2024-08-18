package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ShoppingItemView
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listOfItems = listOf(
            Product(name = "name", price = "price", description = "description"),
            Product(name = "name2", price = "price", description = "description"),
            Product(name = "name3", price = "price", description = "description"),
            Product(name = "name4", price = "price", description = "description"),
            Product(name = "name5", price = "price", description = "description"),
            Product(name = "name6", price = "price", description = "description"),
            Product(name = "name7", price = "price", description = "description"),
            Product(name = "name8", price = "price", description = "description")
        )
        setContent {
            ShoppingCartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                    ) {
                        items(listOfItems) { item ->
                            ShoppingItemView(item)
                        }
                    }
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
