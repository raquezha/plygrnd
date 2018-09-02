package net.raquezha.playground.extensions

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import net.raquezha.playground.keyboard.OnKeyboardVisibilityListener
import net.raquezha.playground.keyboard.visibilityListener


fun Activity.setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val parentView: View = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    parentView.viewTreeObserver.addOnGlobalLayoutListener {
        visibilityListener(parentView, onKeyboardVisibilityListener)
    }
}