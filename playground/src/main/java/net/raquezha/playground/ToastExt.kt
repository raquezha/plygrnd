package net.raquezha.playground

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */
private inline val ctx: Context?
    get() = Playground.app.applicationContext

private var toast: Toast? = null

@SuppressLint("ShowToast")
fun toast(msg: Any?, isShort: Boolean = true) {

    checkNotNull(ctx) {
        throw NullPointerException("Context is null, you should set Playground.with(context) in your Application")
    }

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