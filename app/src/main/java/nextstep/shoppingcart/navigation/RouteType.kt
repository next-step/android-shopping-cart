package nextstep.shoppingcart.navigation

import nextstep.shoppingcart.model.Product

sealed interface RouteType {
    data class ToDetail(val item: Product) : RouteType
    data object ToCart : RouteType
}