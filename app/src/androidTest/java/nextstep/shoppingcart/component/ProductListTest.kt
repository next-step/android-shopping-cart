package nextstep.shoppingcart.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductList
import org.junit.Rule
import org.junit.Test

class ProductListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val productList = listOf(
        Product(
            id = 1,
            imageUrl = "https://www.themealdb.com/images/media/meals/g046bb1663960946.jpg",
            name = "날치알이 생각보다 많은 초밥",
            price = 20000,
        ),
        Product(
            id = 2,
            imageUrl = "https://www.themealdb.com/images/media/meals/d8f6qx1604182128.jpg",
            name = "기본 카츠동",
            price = 11000,
        ),
        Product(
            id = 3,
            imageUrl = "https://www.themealdb.com/images/media/meals/wrustq1511475474.jpg",
            name = "야끼우동",
            price = 12000,
        ),
        Product(
            id = 4,
            imageUrl = "https://www.themealdb.com/images/media/meals/lwsnkl1604181187.jpg",
            name = "너무나 바삭바삭한 돈까스",
            price = 14000,
        ),
    )

    @Test
    fun `주어진_상품의_갯수만큼_표시된다`() {
        composeTestRule.setContent {
            ProductList(
                modifier = Modifier.testTag("ProductListContent"),
                productList = productList,
                cart = Cart(emptyList()),
                onProductClick = {}
            )
        }

        composeTestRule
            .onNodeWithTag("ProductListContent")
            .onChildren()
            .assertCountEquals(productList.size)
    }

    @Test
    fun `클릭한_상품의_정보를_가져온다`() {
        var selectedProduct: Product? = null

        composeTestRule.setContent {
            ProductList(
                modifier = Modifier.testTag("ProductListContent"),
                productList = productList,
                cart = Cart(emptyList()),
                onProductClick = {
                    selectedProduct = it
                }
            )
        }

        composeTestRule
            .onNodeWithTag("ProductListContent")
            .onChildAt(0)
            .performClick()

        assert(selectedProduct == productList[0])

    }
}
