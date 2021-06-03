package com.ae.app_qr_code_01

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_scanqrcode.*


class ScanQrCodeActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "my:ScanQrCodeActivity"
    }

    // properties

    private lateinit var csvScanner: CodeScanner

    // methods - overridden

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanqrcode)
        log("onCreate")

        val scanner = findViewById<CodeScannerView>(R.id.csvScanner)

        csvScanner = CodeScanner(this, scanner)
        csvScanner.setDecodeCallback {
            runOnUiThread {
                tvOutput.text = it.text
            }
        }

        scanner.setOnClickListener {
            csvScanner.startPreview()
        }

        btnStopScan.setOnClickListener {
            csvScanner.stopPreview()
            csvScanner.releaseResources()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
        requestCameraPermission()
    }

    // methods - user defined

    private fun requestCameraPermission() {
        Dexter.withContext(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    log("onPermissionGranted")
                    csvScanner.startPreview()
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    log("onPermissionDenied")
                    showToast("Camera permission is required")
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?, token: PermissionToken?
                ) {
                    log("onPermissionRationaleShouldBeShown")
                    token!!.continuePermissionRequest()
                }
            }).check()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun log(message: String) {
        Log.d(TAG, message)
    }
}