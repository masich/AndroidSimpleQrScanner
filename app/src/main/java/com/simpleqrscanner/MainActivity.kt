package com.simpleqrscanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readQrCode()
    }


    private fun readQrCode() {
        val integrator = IntentIntegrator(this)
        integrator.setOrientationLocked(false)
        integrator.initiateScan()
    }
}