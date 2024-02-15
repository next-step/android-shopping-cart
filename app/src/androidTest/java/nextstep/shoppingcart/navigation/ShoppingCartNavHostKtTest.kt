package nextstep.shoppingcart.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import nextstep.shoppingcart.ui.screen.cart.navigation.CartNavigationRoute
import nextstep.shoppingcart.ui.screen.product.list.navigation.ProductListNavigationRoute
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingCartNavHostKtTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(context = LocalContext.current)
            navController.navigatorProvider
                .addNavigator(ComposeNavigator())
            ShoppingCartNavHost(navController = navController)
        }
    }

    @Test
    fun 첫화면은_상품목록화면입니다() {
        // given

        // when
        val actual = navController.currentDestination?.route

        // then
        assert(actual == ProductListNavigationRoute)
    }

    @Test
    fun 장바구니_버튼을_클릭하면_장바구니_화면으로_이동합니다() {
        // given

        // when
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()

        // then
        val actual = navController.currentDestination?.route
        assert(actual == CartNavigationRoute)
    }

    @Test
    fun 장바구니_화면에서_뒤로가기_버튼을_클릭하면_상품목록화면입니다() {
        // given
        composeTestRule
            .onNodeWithContentDescription("장바구니")
            .performClick()

        // when
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        val actual = navController.currentDestination?.route
        assert(actual == ProductListNavigationRoute)
    }
}
