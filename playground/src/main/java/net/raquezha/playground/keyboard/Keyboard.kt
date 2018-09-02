package net.raquezha.playground.keyboard

import android.graphics.Rect
import android.os.Build
import android.util.TypedValue
import android.view.View


interface OnKeyboardVisibilityListener {
    fun onVisibilityChanged(visible: kotlin.Boolean)
}

fun visibilityListener(parentView: View, onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val defaultKeyboardHeightDP = 100
    val estimatedKeyboardDP = defaultKeyboardHeightDP + if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)) 48 else 0
    val rect = Rect()

    val estimatedKeyboardHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, estimatedKeyboardDP.toFloat(), parentView.resources.displayMetrics)
    parentView.getWindowVisibleDisplayFrame(rect)
    val heightDiff = parentView.rootView.height - (rect.bottom - rect.top)
    val isShown = heightDiff >= estimatedKeyboardHeight

    onKeyboardVisibilityListener.onVisibilityChanged(isShown)
}