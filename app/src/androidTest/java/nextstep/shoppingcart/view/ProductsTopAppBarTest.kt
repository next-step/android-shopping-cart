package nextstep.shoppingcart.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductsTopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductsTopAppBar()
        }
    }

    @Test
    fun 상품_목록_타이틀이_표시된다() {
        composeTestRule.onNodeWithText("상품 목록").assertExists()
    }

    @Test
    fun 카트_아이콘이_표시된다() {
        composeTestRule.onNodeWithContentDescription("Cart Icon").assertExists()
    }
}