package com.simpleqrscanner

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.simpleqrscanner.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readQrCode()
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        onQRScanResult(scanResult)
    }

    fun onQRScanResult(data: IntentResult?) {
        if (data?.contents == null)
            finish()
        else {
            link.text = data.contents
            open_link.setOnClickListener {
                try {
                    startActivity(Intent(ACTION_VIEW, Uri.parse(data.contents)))
                } catch (e: ActivityNotFoundException) {
                    toast(getString(R.string.activity_not_found))
                }

            }
        }
    }

    private fun readQrCode() {
        val integrator = IntentIntegrator(this)
        integrator.setOrientationLocked(false)
        integrator.initiateScan()
    }
}