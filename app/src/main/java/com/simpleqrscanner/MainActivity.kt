package com.simpleqrscanner

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readQrCode()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        onQRScanResult(scanResult)
    }

    fun onQRScanResult(data: IntentResult?) {
        if (data == null)
            finish()
        else {
            link.text = data.contents
            open_link.setOnClickListener {
                startActivity(Intent(ACTION_VIEW, Uri.parse(data.contents)))
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