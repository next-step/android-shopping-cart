package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.ProductDetailScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = Product(
        id = 10,
        imageUrl = "https://www.themealdb.com/images/media/meals/1525874812.jpg",
        name = "마라보다 맵디매운 마파 두부",
        price = 28000,
    )

    private var isButtonClicked = false

    @Before
    fun setUp() {
        isButtonClicked = false
        composeTestRule.setContent {
            ProductDetailScreen(
                product = product,
                onBackButtonClick = {},
                onAddCartClick = { isButtonClicked = true },
            )
        }
    }

    @Test
    fun `상품_이미지를_보여준다`() {
        composeTestRule
            .onNodeWithContentDescription(product.imageUrl)
            .assertIsDisplayed()
    }

    @Test
    fun `상품_이름을_보여준다`() {
        composeTestRule
            .onNodeWithText(product.name)
            .assertIsDisplayed()
    }

    @Test
    fun `상품가격은_금액형식으로_보여준다`() {
        composeTestRule
            .onNodeWithText("28,000원")
            .assertIsDisplayed()
    }

    @Test
    fun `장바구니_담기는_클릭가능하다`() {
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .performClick()

        assert(isButtonClicked)
    }

}
