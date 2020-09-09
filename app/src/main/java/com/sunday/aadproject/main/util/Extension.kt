package com.sunday.aadproject.main.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.EditText
import android.widget.Toast

fun Context.internetConnected(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}

fun Context.toastMsg(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun EditText.notEmpty(): Boolean {
    return this.text.isNotEmpty()
}