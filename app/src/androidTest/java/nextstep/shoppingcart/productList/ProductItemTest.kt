package nextstep.shoppingcart.productList

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var product: Product

    @Before
    fun setUp() {
        product = Product(
            id = 1,
            name = "상품",
            price = 10000,
            imageUrl = ""
        )
    }

    @Test
    fun product의_name이_상품일_때_상품_텍스트가_노출되어야_한다() {
        // given
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithText("상품")
            .assertExists()
    }

    @Test
    fun product의_price가_10000일_때_10_000원_텍스트가_노출되어야_한다() {
        // given
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()
    }

    @Test
    fun product의_count가_0이면_장바구니_추가_버튼이_보여야_한다() {
        // given
        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("product_add_button")
            .isDisplayed()
    }

    @Test
    fun product의_count가_3이면_장바구니_추가_버튼이_보이지_않아야_한다() {
        // given
        val product = this.product.copy(count = 3)

        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("product_add_button")
            .isNotDisplayed()
    }


    @Test
    fun product의_count가_3이면_장바구니_수량_조절_컴포넌트가_보여야_한다() {
        // given
        val product = this.product.copy(count = 3)

        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("quantity_control")
            .isNotDisplayed()
    }

    @Test
    fun product의_count가_0이면_장바구니_수량_조절_컴포넌트가_보이지_않아야_한다() {
        // given
        val product = this.product.copy()

        composeTestRule.setContent {
            ProductItem(
                product = product,
                onClick = {},
                onPlusClick = {},
                onMinusClick = {}
            )
        }

        // then
        composeTestRule
            .onNodeWithTag("quantity_control")
            .isDisplayed()
    }
}