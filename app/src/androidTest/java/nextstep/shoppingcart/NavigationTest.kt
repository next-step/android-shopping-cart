package nextstep.shoppingcart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품_목록_탭으로_이동할_수_있다() {
        // given when
        composeTestRule.setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                AppNavHost(
                    navHostController = rememberNavController(),
                    startDestination = "Products",
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("상품 목록")
            .assertExists()
    }

    @Test
    fun 상품_상세_탭으로_이동할_수_있다() {
        // given when
        composeTestRule.setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                AppNavHost(
                    navHostController = rememberNavController(),
                    startDestination = "ProductDetail",
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("상품 상세")
            .assertExists()
    }

    @Test
    fun 장바구니_탭으로_이동할_수_있다() {
        // given when
        composeTestRule.setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                AppNavHost(
                    navHostController = rememberNavController(),
                    startDestination = "Cart",
                )
            }
        }

        // then
        composeTestRule
            .onNodeWithText("장바구니")
            .assertExists()
    }
}
