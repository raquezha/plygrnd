package net.raquezha.playground

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


interface OnKeyboardVisibilityListener {
    fun onVisibilityChanged(visible: kotlin.Boolean)
}


fun AppCompatActivity.setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val parentView: View = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    parentView.viewTreeObserver.addOnGlobalLayoutListener {
        visibilityListener(parentView, onKeyboardVisibilityListener)
    }
}
fun FragmentActivity.setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val parentView: View = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    parentView.viewTreeObserver.addOnGlobalLayoutListener {
        visibilityListener(parentView, onKeyboardVisibilityListener)
    }
}

fun View.setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
    val parentView: View = findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    parentView.viewTreeObserver.addOnGlobalLayoutListener {
        visibilityListener(parentView, onKeyboardVisibilityListener)
    }
}

private fun visibilityListener(parentView: View, onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {

    val alreadyOpen = false
    val defaultKeyboardHeightDP = 100;
    val estimatedKeyboardDP = defaultKeyboardHeightDP + if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)) 48 else 0
    val rect = Rect()


    val estimatedKeyboardHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, estimatedKeyboardDP.toFloat(), parentView.resources.displayMetrics)
    parentView.getWindowVisibleDisplayFrame(rect);
    val heightDiff = parentView.rootView.height - (rect.bottom - rect.top)
    val isShown = heightDiff >= estimatedKeyboardHeight

    if (isShown == alreadyOpen) {
        Log.e("Keyboard state", "Ignoring global layout change...")
    } else {
        Log.e("Keyboard state", "now shown")
    }

    onKeyboardVisibilityListener.onVisibilityChanged(isShown)


}