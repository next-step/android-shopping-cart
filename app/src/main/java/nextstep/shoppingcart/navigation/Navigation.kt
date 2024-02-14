package nextstep.shoppingcart.navigation

internal sealed class Navigation(val route: String) {

    data object ProductList : Navigation("ProductList")

    data object ProductDetail : Navigation("ProductDetail")

    data object Cart : Navigation("Cart")

}
