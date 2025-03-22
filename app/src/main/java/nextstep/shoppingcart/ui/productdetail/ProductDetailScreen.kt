package nextstep.shoppingcart.ui.productdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ProductDetailTopAppBar(onBackClick = onBackClick)
        },
        containerColor = Color.White
    ) { paddingValues ->
        ProductDetailColumn(
            product = product,
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            onAddToCartClick = onAddToCartClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                "https://s3-alpha-sig.figma.com/img/05ef/e578/d81445480aff1872344a6b1b35323488?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=iAnCjlosczr-wNaf-XUWxSynLvrnjQ8SwbkO7YN2A9cpfw8wcUsrMIpi6HDyslQFsSZ1pyb81Gw3LSDsplfPfSS9QDBa5sSCorviFhyBdsWBeU77xktfS3b3iID0cIbtEoLrag09FgNm4jVlLQdpNXPv98G3vGCk7FdVxgVSjdOMRUpCOeuEqEZX2agJtgebpfdcEz4ZfCqXxxkKa0epVujkqudUiu9iReulyaNMtUWZWzbF0zmj4-F2rVjK8M2rX~OfswEvRv3Mxu2qTrO8xRyL36~3VDIxdlpzIKrM0gGtBBpQ73XsmzugfyyOHk2Ak8PB5GKgBC0XZnthpAL3Lg__",
                "PET보틀-원형(500ml)",
                10000
            )
        )
    }
}