package nextstep.shoppingcart

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToIndex
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.list.component.ProductItem
import org.junit.Rule
import org.junit.Test

class LazyVerticalGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_show_product_item_when_lazy_vertical_grid_has_product_item() {

        //given
        val mockProducts = listOf(
            Product(
                id = 1,
                name = "PET-보틀-정사각형정사각형정사각형정사각형1",
                price = 10000,
                imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
            )
        )

        //when
        composeTestRule.setContent {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(mockProducts) {
                    ProductItem(item = it)
                }
            }
        }

        //then
        composeTestRule.onNodeWithText("PET-보틀-정사각형정사각형정사각형정사각형1").assertExists()
    }

    @Test
    fun should_not_same_layout_node_count_when_lazy_vertical_grid_has_many_product_items() {

        //given
        val mockProducts = (1..10000).map {
            Product(
                id = it,
                name = "PET-보틀-정사각형정사각형정사각형정사각형$it",
                price = (10000 + it),
                imageUrl = "$it"
            )
        }

        composeTestRule.setContent {
            LazyVerticalGrid(
                modifier = Modifier.testTag("lazyVerticalGrid"),
                columns = GridCells.Fixed(2)
            ) {
                items(mockProducts) {
                    ProductItem(
                        modifier = Modifier.testTag("product"),
                        item = it
                    )
                }
            }
        }

        //when
        composeTestRule.onNodeWithTag("lazyVerticalGrid").performScrollToIndex(9999)


        //then
        assert(composeTestRule.onAllNodesWithTag("product").fetchSemanticsNodes().size < 10000)
    }
}