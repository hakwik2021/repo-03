package com.ae.app_qr_code_01

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

/**
 * firebase project name    :
 * android project name     :   app-qr-code-01
 * android application id   :   com.ae.app_qr_code_01
 * description              :
 *  - qr code generator
 *  - https://github.com/androidmads/qrgenerator
 *  - https://www.youtube.com/watch?v=NpVRUhEpRI8&list=PLlGT4GXi8_8dCrFh5HubaRFENzbnNe5xz
 */

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "my:MainActivity"
    }

    // methods - overridden

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        log("onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_create_qr_code -> {
                log("action_create_qr_code")
                createQrCode()
                return true
            }
            R.id.action_scan_qr_code -> {
                log("action_scan_qr_code")
                scanQrCode()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // methods - user defined

    private fun createQrCode() {
        log("createQrCode")
        startActivity(Intent(applicationContext, CreateQrCodeActivity::class.java))
    }

    private fun scanQrCode() {
        log("scanQrCode")
        startActivity(Intent(applicationContext, ScanQrCodeActivity::class.java))
    }

    private fun log(message: String) {
        Log.d(TAG, message)
    }
}
