package nextstep.shoppingcart.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductListContent
import org.junit.Rule
import org.junit.Test

class ProductListContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun `주어진_상품의_갯수만큼_표시된다`() {
        //given
        val productList = listOf(
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

        composeTestRule.setContent {
            ProductListContent(
                productList = productList,
                modifier = Modifier.testTag("ProductListContent")
            )
        }

        composeTestRule
            .onAllNodesWithTag("ProductItem")
            .assertCountEquals(productList.size)
    }
}
