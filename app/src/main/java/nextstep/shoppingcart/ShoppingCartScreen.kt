package nextstep.shoppingcart

import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.component.toolbar.ShoppingCartToolbar
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
fun ShoppingCartScreen() {

}

/**
 * Shopping cart screen 함수
 * overloading 하여 값을 외부에서 바꿀수 있도록 한다
 * preview 등에서 조작 하기 위해
 */
@Composable
fun ShoppingCartScreen(
	modifier: Modifier = Modifier,
){
	Scaffold(
		modifier =  modifier,
		topBar = {
			ShoppingCartToolbar()
		}
	) { contentPadding ->


	}
}

/**
 * Shopping cart screen 프리뷰 함수
 */
@Preview
@Composable
fun ShoppingCartScreenPreview() {
	ShoppingCartTheme{
		ShoppingCartScreen(
			modifier = Modifier.background(Color.White)
		)
	}
}