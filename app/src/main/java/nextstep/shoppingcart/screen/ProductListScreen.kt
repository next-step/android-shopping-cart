package nextstep.shoppingcart.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.product.ProductList
import nextstep.shoppingcart.component.toolbar.ShoppingCartToolbar
import nextstep.shoppingcart.mock.shoppingItemMockList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

/**
 * Create Date: 2024. 8. 25.
 *
 * Description: 장바구니 screen 컴포즈 구성
 * @author LeeDongHun
 *
 * @see
 * */
@Composable
fun ProductListScreen(
	navigateToProductDetailScreen: (clickedProductId: Int) -> Unit = {},
	navigateToShoppingCartScreen: () -> Unit = {},
) {
	ProductListScreen(
		modifier = Modifier.fillMaxSize(),
		navigateToProductDetailScreen = { clickedProductId ->
			navigateToProductDetailScreen(clickedProductId)
		},
		navigateToShoppingCartScreen = {
			navigateToShoppingCartScreen()
		}
	)
}

/**
 * Shopping cart screen 함수
 * overloading 하여 값을 외부에서 바꿀수 있도록 한다
 * preview 등에서 조작 하기 위해
 */
@Composable
fun ProductListScreen(
	modifier: Modifier = Modifier,
	navigateToProductDetailScreen: (clickedProductId: Int) -> Unit = {},
	navigateToShoppingCartScreen: () -> Unit = {},
) {
	Scaffold(
		modifier = modifier,
		topBar = {
			ShoppingCartToolbar(
				actionIconClicked = {
					navigateToShoppingCartScreen()
				}
			)
		}
	) { contentPadding ->
		ProductList(
			modifier = Modifier.padding(10.dp),
			contentPadding = contentPadding,
			productList = shoppingItemMockList,
		) { clickedShoppingItem -> // 상품 클릭 시 상세 화면으로 이동
			navigateToProductDetailScreen(clickedShoppingItem.id)
		}
	}
}

/**
 * Shopping cart screen 프리뷰 함수
 */
@Preview
@Composable
fun ProductListScreenPreview() {
	ShoppingCartTheme {
		ProductListScreen(
			modifier = Modifier.background(Color.White)
		)
	}
}
