package net.raquezha.playground.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import net.raquezha.playground.Playground

private inline val ctx: Context?
    get() = checkNotNull(Playground.app) { throw NullPointerException("You should set `Playground.with(app)` in your Application")}

private var toast: Toast? = null

@SuppressLint("ShowToast")
fun toast(msg: Any?, isShort: Boolean = true) {

    msg?.let {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg.toString(), Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg.toString())
        }
        toast!!.duration = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
        toast!!.show()
    }
}