package net.raquezha.playground.extensions

import android.util.Log
import net.raquezha.playground.Playground

inline val tag: String?
    get() = Playground.tag

fun Any.log(log: String, TAG: String = tag!!) = Log.e(TAG, log)

fun Any.logV(log: String, TAG: String = tag!!) = Log.e(TAG, log)

fun Any.logE(log: String, TAG: String = tag!!) = Log.e(TAG, log)

fun Any.logD(log: String, TAG: String = tag!!) = Log.e(TAG, log)

fun Any.logI(log: String, TAG: String = tag!!) = Log.e(TAG, log)

fun Any.logW(log: String, TAG: String = tag!!) = Log.e(TAG, log)
