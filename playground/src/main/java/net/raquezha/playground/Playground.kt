package net.raquezha.playground

import android.app.Application

object Playground {
    lateinit var app: Application
    var tag: String = this::class.java.simpleName

    fun with(app: Application, tag: String = this::class.java.simpleName) {
        this.app = app
        this.tag = tag
    }

}