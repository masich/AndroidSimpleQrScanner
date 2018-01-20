package com.simpleqrscanner.utils

import android.app.Activity
import android.util.Log

/**
 * Created by masic on 20.01.2018
 * Project: AndroidSimpleQrScanner
 */
fun Activity.logD(message: String) {
    Log.d(this::class.java.simpleName, message)
}