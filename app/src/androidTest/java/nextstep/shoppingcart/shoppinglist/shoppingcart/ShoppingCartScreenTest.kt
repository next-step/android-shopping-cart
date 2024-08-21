package nextstep.shoppingcart.shoppinglist.shoppingcart

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

class ShoppingCartScreenTest {

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
    fun 상품_목록뷰에서_장바구니_뷰로_진입한_경우_뒤로가기_버튼을_누르면_상품_목록뷰로_돌아간다() {
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
    fun 상품_상세보기뷰에서_장바구니_뷰로_진입한_경우_뒤로가기_버튼을_누르면_상품_상세보기뷰로_돌아간다() {
        // given:
        composeTestRule.onAllNodesWithContentDescription("ShoppingItem").onFirst().performClick()
        composeTestRule.onNodeWithContentDescription("ShoppingDetailAddButton").performClick()

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingTopBarBackIcon").performClick()

        // then:
        val currentScreen = navController.currentBackStackEntry?.destination?.route
        val expected = "ShoppingDetailScreen/{productId}"

        assert(currentScreen == expected)
    }
}
