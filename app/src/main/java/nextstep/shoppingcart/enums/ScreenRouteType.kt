package nextstep.shoppingcart.enums

/**
 * Create Date: 2024. 9. 2.
 *
 * Description: 화면 이동을 navRoute로 관리하는 enum 클래스
 * @author LeeDongHun
 *
 */
enum class ScreenRouteType(val navRoute: String) {

    /**
     * 상품 목록 화면
     */
    SHOPPING_ITEM_LIST("shopping_item_list"),

    /**
     * 상품 상세 화면
     */
	PRODUCT_DETAIL("product_detail"),

    /**
     * 장바구니 화면
     */
    SHOPPING_CART("shopping_cart"),
}
