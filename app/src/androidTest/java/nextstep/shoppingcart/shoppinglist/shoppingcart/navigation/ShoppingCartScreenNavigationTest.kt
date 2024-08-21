package nextstep.shoppingcart.shoppinglist.shoppingcart.navigation

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

class ShoppingCartScreenNavigationTest {

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
        }
    }

    @Test
    fun 뒤로가기_버튼을_클릭할_경우_이전_뷰로_돌아간다1() {
        // given:
        composeTestRule.onNodeWithContentDescription("ShoppingCartIcon").performClick()

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingTopBarBackIcon").performClick()

        // then:
        val currentScreen = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingListScreen"

        assert(currentScreen == expected)
    }

    @Test
    fun 뒤로가기_버튼을_클릭할_경우_이전_뷰로_돌아간다2() {
        // given:
        composeTestRule.onAllNodesWithContentDescription("ShoppingListItem").onFirst().performClick()
        composeTestRule.onNodeWithContentDescription("ShoppingButton").performClick()

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingTopBarBackIcon").performClick()

        // then:
        val currentScreen = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingDetailScreen/{productId}"

        assert(currentScreen == expected)
    }
}
