package nextstep.shoppingcart.ui

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import nextstep.shoppingcart.navigation.Navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navHostController = navController)
        }
    }

    @Test
    fun 시작화면은_상품목록이다() {
        // given: nothing
        // when
        val actual = navController.currentBackStackEntry?.destination?.route

        // then
        assert(actual == Navigation.ProductList.route)
    }

    @Test
    fun 장바구니_버튼을_클릭하면_장바구니_화면으로_이동한다() {
        // when
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()

        // then
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.Cart.route)
    }

    @Test
    fun 상품목록에서_장바구니_화면으로_이동하고_뒤로가기_버튼을_클릭하면_상품목록으로_돌아온다() {
        // given
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()

        // when
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        val actual = navController.currentBackStackEntry?.destination?.route
        assert(actual == Navigation.ProductList.route)
    }
}
