package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import nextstep.shoppingcart.model.ProductModel
import org.junit.Rule
import org.junit.Test

class ProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품목록_아이템에_상품이미지_상품명_상품가가격_노출() {
        // given
        val model = ProductModel(
            id = 6871,
            imageUrl = "http://www.bing.com/search?q=nominavi",
            name = "Adan Sawyer",
            price = 1281
        )
        composeTestRule.setContent {
            Product(model)
        }

        // then
        composeTestRule
            .onNodeWithTag("productItem")
            .onChildren()
            .assertCountEquals(3)
    }
}