package nextstep.shoppingcart.ui.product.list.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.domain.model.Product
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_이름은_그대로_출력한다() {
        // given
        val productName = "PET보틀-정사각"
        val product = fakeProduct(name = productName)

        // when
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onAddClick = { },
                onItemClick = { },
            )
        }

        // then
        composeTestRule
            .onNodeWithText(productName)
            .assertIsDisplayed()
    }

    @Test
    fun 상품의_가격은_원화_단위로_출력한다() {
        // given
        val productPrice = 44100
        val product = fakeProduct(price = productPrice)

        // when
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onAddClick = { },
                onItemClick = { },
            )
        }

        // then
        composeTestRule
            .onNodeWithText("44,100원")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니_추가_버튼을_클릭할_수_있다() {
        // given
        val product = fakeProduct()

        // when
        var clicked = false
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onAddClick = { clicked = true },
                onItemClick = { },
            )
        }
        composeTestRule
            .onNodeWithContentDescription("장바구니 추가")
            .performClick()

        // then
        assert(clicked)
    }

    @Test
    fun 아이템을_클릭할_수_있다() {
        // given
        val product = fakeProduct()

        // when
        var clicked = false
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onAddClick = { },
                onItemClick = { clicked = true },
            )
        }
        composeTestRule
            .onRoot()
            .performClick()

        // then
        assert(clicked)
    }

    private fun fakeProduct(
        name: String = "",
        price: Int = 0,
        imageUrl: String = "",
    ) = Product(
        id = "",
        name = name,
        price = price,
        imageUrl = imageUrl,
    )
}
