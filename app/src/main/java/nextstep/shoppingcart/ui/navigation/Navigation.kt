package nextstep.shoppingcart.ui.navigation

sealed class Navigation(val route: String) {

    data object ProductList : Navigation("ProductList")

    data object ProductDetail : Navigation("ProductDetail")

    data object Cart : Navigation("Cart")

}
