package nextstep.shoppingcart.ui.product.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.product.list.component.ProductListItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductListItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var item by mutableStateOf(
        Product(
            name = "",
            imageUrl = "",
            price = 0,
        )
    )

    @Before
    fun setup() {
        composeTestRule.setContent {
            ProductListItem(
                item = item,
                count = 0,
                onClickCountIncrease = {},
                onClickCountDecrease = {},
                onClick = {},
            )
        }
    }

    @Test
    fun 프로덕트_이름이_표시되어야_한다() {
        // given
        val productName = "product1"

        // when
        item = Product(
            name = productName,
            imageUrl = "",
            price = 0,
        )

        //then
        composeTestRule.onNodeWithText(productName).assertExists()
    }

    @Test
    fun 프로덕트_가격은_포맷팅_되어_표시되어야_한다() {
        // given
        val productPrice = 1_900_000L

        // when
        item = Product(
            name = "",
            imageUrl = "",
            price = productPrice,
        )

        //then
        composeTestRule.onNodeWithText("1,900,000원").assertExists()
    }

}
