package com.ogulcan.android.mvp.app.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}