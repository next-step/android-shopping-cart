package nextstep.shoppingcart.shoppinglist.screen

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import nextstep.shoppingcart.ui.AppNavHost
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navController = navController)
        }
    }

    @Test
    fun 시작_화면은_상품_목록_뷰이다() {
        // given:
        // when:
        val currentScreen = navController.currentBackStackEntry?.destination?.route

        // then:
        val expected = "ShoppingListScreen"

        assert(currentScreen == expected)
    }

    @Test
    fun 상품을_클릭하면_상품_상세보기_뷰로_이동한다() {
        // given:
        // when:
        composeTestRule.onAllNodesWithContentDescription("ShoppingItem").onFirst()
            .performClick()

        // then:
        val actual = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingDetailScreen/{productId}"

        assert(actual == expected)
    }

    @Test
    fun 장바구니_아이콘을_클릭하면_장바구니_뷰로_이동한다() {
        // given:
        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingCartIcon").performClick()

        // then:
        val actual = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingCartScreen"

        assert(actual == expected)
    }
}
