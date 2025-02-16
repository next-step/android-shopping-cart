package nextstep.shoppingcart.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductItem
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = Product(
        id = 123123123,
        imageUrl = "https://picsum.photos/200",
        name = "상품",
        price = 123456789,
    )

    @Test
    fun `상품가격은_금액형식으로_나온다`() {
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onProductClick = {}
            )
        }

        composeTestRule
            .onNodeWithText("123,456,789원")
            .assertIsDisplayed()
    }

    @Test
    fun `클릭시_상품의_정보를_가져온다`() {
        var selectedProduct: Product? = null

        composeTestRule.setContent {
            ProductItem(
                modifier = Modifier.testTag(product.name),
                product = product,
                onProductClick = { selectedProduct = it }
            )
        }
        composeTestRule
            .onNodeWithTag(product.name)
            .performClick()

        assert(selectedProduct == product)

    }
}
