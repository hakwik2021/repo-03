package com.ae.app_qr_code_01

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_createqrcode.*

class CreateQrCodeActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "my:CreateQrCodeActivity"
    }

    // methods - overridden

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createqrcode)

        btnCreateQrCode.setOnClickListener {
            val name = etName.text.toString()
            val postal = etPostal.text.toString()
            val phone = etPhone.text.toString()
            val temperature = etTemperature.text.toString()
            val person = Person(name, postal, phone, temperature)
            generateQrCodeUsingObject(person)
            //generateQrCodeUsingBundle(person)
        }
    }

    // methods - user defined

    private fun generateQrCodeUsingObject(person: Person) {

        val qrgEncoder = QRGEncoder(
            "${person.name};${person.postal};${person.phone};${person.temperature};",
            null,
            QRGContents.Type.TEXT,
            500
        )
        try {
            val qrBitmap = qrgEncoder.bitmap
            ivOutput.setImageBitmap(qrBitmap)
        } catch (e: Exception) {
            log("error: $e")
        }
    }

    private fun generateQrCodeUsingBundle(person: Person) {
        val bundle = Bundle()
        bundle.putString(ContactsContract.Intents.Insert.NAME, person.name)
        bundle.putString(ContactsContract.Intents.Insert.POSTAL, person.postal)
        bundle.putString(ContactsContract.Intents.Insert.PHONE, person.phone)

        val qrgEncoder = QRGEncoder(null, bundle, QRGContents.Type.CONTACT, 500)
        try {
            val qrBitmap = qrgEncoder.bitmap
            ivOutput.setImageBitmap(qrBitmap)
        } catch (e: Exception) {
            log("error: $e")
        }
    }


    private fun log(message: String) {
        Log.d(TAG, message)
    }
}

//        btnGenerate.setOnClickListener {
//            val person = Person("Andy", "Paranaque", "09061234567")
//            generateQrCodeUsingObject(person)
//        }

//        btnScan.setOnClickListener {
//            startActivity(Intent(applicationContext, ScanQrActivity::class.java))
//        }
//}

// methods - user defined

//    private fun generateQrCodeUsingString(input: String) {
//        val qrgEncoder = QRGEncoder(input, null, QRGContents.Type.TEXT, 500)
//        try {
//            val qrBitmap = qrgEncoder.bitmap
//            ivOutput.setImageBitmap(qrBitmap)
//        } catch (e: Exception) {
//            log("error: $e")
//        }
//    }
//
//    private fun generateQrCodeUsingBundle(person: Person) {
//        val bundle = Bundle()
//        bundle.putString(ContactsContract.Intents.Insert.NAME, person.name)
//        bundle.putString(ContactsContract.Intents.Insert.POSTAL, person.postal)
//        bundle.putString(ContactsContract.Intents.Insert.PHONE, person.phone)
//
//        val qrgEncoder = QRGEncoder(null, bundle, QRGContents.Type.CONTACT, 500)
//        try {
//            val qrBitmap = qrgEncoder.bitmap
//            ivOutput.setImageBitmap(qrBitmap)
//        } catch (e: Exception) {
//            log("error: $e")
//        }
//    }
//
//    private fun generateQrCodeUsingObject(person: Person) {
//
//        val qrgEncoder = QRGEncoder(
//            "${person.name};${person.postal};${person.phone};",
//            null,
//            QRGContents.Type.TEXT,
//            500
//        )
//        try {
//            val qrBitmap = qrgEncoder.bitmap
//            ivOutput.setImageBitmap(qrBitmap)
//        } catch (e: Exception) {
//            log("error: $e")
//        }
