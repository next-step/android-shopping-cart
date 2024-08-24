package nextstep.shoppingcart.component

import androidx.compose.ui.graphics.vector.ImageVector
import nextstep.shoppingcart.component.iconpack.Remove
import kotlin.collections.List as ____KtList

public object IconPack

private var __nextstep: ____KtList<ImageVector>? = null

public val IconPack.nextstep: ____KtList<ImageVector>
  get() {
    if (__nextstep != null) {
      return __nextstep!!
    }
    __nextstep= listOf(Remove)
    return __nextstep!!
  }
