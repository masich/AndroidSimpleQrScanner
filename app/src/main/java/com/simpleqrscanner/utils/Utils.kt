package com.simpleqrscanner.utils

import android.app.Activity
import android.util.Log
import android.widget.Toast

/**
 * Created by masic on 20.01.2018
 * Project: AndroidSimpleQrScanner
 */
fun Activity.logD(message: String) {
    Log.d(this::class.java.simpleName, message)
}

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}