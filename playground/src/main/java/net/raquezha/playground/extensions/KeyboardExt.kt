package net.raquezha.playground.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import net.raquezha.playground.keyboard.OnKeyboardVisibilityListener
import net.raquezha.playground.keyboard.visibilityListener


fun Activity.setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val parentView: View = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    parentView.viewTreeObserver.addOnGlobalLayoutListener {
        visibilityListener(parentView, onKeyboardVisibilityListener)
    }
}


fun Activity.hideKeyboard() {
    val rootView = window.decorView.rootView
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(rootView.windowToken, 0)
}

fun Activity.showKeyboard() {
    val rootView = window.decorView.rootView
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(rootView, InputMethodManager.SHOW_IMPLICIT)
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
}

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.showKeyboard() {

    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    (context as Activity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
}

