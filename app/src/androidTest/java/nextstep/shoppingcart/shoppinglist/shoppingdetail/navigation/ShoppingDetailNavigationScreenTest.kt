package nextstep.shoppingcart.shoppinglist.shoppingdetail.navigation

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

class ShoppingDetailNavigationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.apply {
            setContent {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                AppNavHost(navController = navController)
            }
        }.also {
            it.onAllNodesWithContentDescription("ShoppingItem").onFirst().performClick()
        }
    }

    @Test
    fun 뒤로가기_버튼을_클릭할_경우_이전뷰로_이동한다() {
        // given:
        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingTopBarBackIcon").performClick()

        // then:
        val currentScreen = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingListScreen"

        assert(currentScreen == expected)
    }

    @Test
    fun 장바구니담기_버튼을_클릭할_경우_장바구니_뷰로_이동한다() {
        // given:
        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingButton").performClick()

        // then:
        val currentScreen = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingCartScreen"

        assert(currentScreen == expected)
    }
}
