package net.raquezha.playground

import android.util.Log

inline val tag: String?
    get() = Playground.tag

fun Any.log(log: String) = Log.e(tag, log)

fun Any.logV(log: String) = Log.v(tag, log)

fun Any.logE(log: String) = Log.e(tag, log)

fun Any.logD(log: String) = Log.d(tag, log)

fun Any.logI(log: String) = Log.i(tag, log)

fun Any.logW(log: String) = Log.w(tag, log)
