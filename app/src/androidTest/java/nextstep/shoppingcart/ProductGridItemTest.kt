package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.catalog.component.ProductGridItem
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

class ProductGridItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `가격이_형식에_맞게_출력되는지_테스트`() {
        // given
        val price = 50000

        // when
        composeTestRule.setContent {
            ProductGridItem(
                Product(
                    name = "",
                    price = price,
                    imageUrl = "",
                )
            )
        }

        // then
        composeTestRule
            .onNodeWithText("50,000원")
            .assertExists()
    }
}