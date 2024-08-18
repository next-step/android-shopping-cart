package nextstep.shoppingcart.ui.iconpack

import androidx.compose.ui.graphics.vector.ImageVector
import nextstep.shoppingcart.ui.iconpack.iconpack.IcMinus
import nextstep.shoppingcart.ui.iconpack.iconpack.IcPlus
import kotlin.collections.List as ____KtList

public object IconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val IconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(IcPlus, IcMinus)
    return __AllIcons!!
  }
