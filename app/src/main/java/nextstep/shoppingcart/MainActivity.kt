package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.ui.productlist.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    private val products: List<Product> = listOf(
        Product(
            id = 1,
            imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
            name = "루바토 브이넥 반팔 티셔츠 네이비",
            price = 16371
        ),
        Product(
            id = 2,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240404/4022896/4022896_17132431505458_500.jpg",
            name = "TCM starfish backpack (black)",
            price = 87200
        ),
        Product(
            id = 3,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240206/3848632/3848632_17090115351739_500.jpg",
            name = "Starfish Damage Ball Cap(BLUE)",
            price = 59000
        ),
        Product(
            id = 4,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240516/4135365/4135365_17161647453804_500.jpg",
            name = "링클 체크 박시 오버핏 롤업 하프 셔츠 블루",
            price = 37400
        ),
        Product(
            id = 5,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240201/3840937/3840937_17083068789627_500.jpg",
            name = "Cut Off Curved Denim Pants - Black",
            price = 69000
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductListScreen(
                        products = products,
                        onActionClick = {
                            val intent = Intent(this, ShoppingCartActivity::class.java)
                            startActivity(intent)
                        },
                        onProductClick = { product ->
                            val intent = Intent(this, ProductDetailActivity::class.java)
                            intent.putExtra("product", product)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}
