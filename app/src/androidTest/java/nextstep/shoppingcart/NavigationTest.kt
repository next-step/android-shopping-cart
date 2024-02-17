package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.ui.AppNavHost
import nextstep.shoppingcart.ui.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: NavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navHostController = navController)
        }
    }

    @Test
    fun 시작화면은_상품리스트_화면이다() {
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.ProductList.route)
    }

    @Test
    fun 상품목록_화면에서_장바구니_클릭시_장바구니로_이동한다() {
        // given
        시작화면은_상품리스트_화면이다()
        // when
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()
        val current = navController.currentBackStackEntry?.destination?.route

        // then
        composeTestRule
            .onNodeWithText("장바구니")
            .assertExists()
        assert(current == Navigation.Cart.route)
    }

    @Test
    fun 상품목록_화면에서_장바구니_화면으로_이동후_뒤로가면_상품목록으로_이동한다() {

        // given
        상품목록_화면에서_장바구니_클릭시_장바구니로_이동한다()

        // when
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        val current = navController.currentBackStackEntry?.destination?.route
        assert(current == Navigation.ProductList.route)
    }
}
