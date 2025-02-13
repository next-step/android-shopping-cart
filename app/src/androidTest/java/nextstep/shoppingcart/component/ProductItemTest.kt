package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductItem
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `상품가격은_금액형식으로_나온다`() {
        composeTestRule.setContent {
            ProductItem(
                Product(
                    id = 1,
                    imageUrl = "https://picsum.photos/200",
                    name = "상품",
                    price = 123456789,
                )
            )
        }

        composeTestRule
            .onNodeWithText("123,456,789원")
            .assertIsDisplayed()
    }
}
