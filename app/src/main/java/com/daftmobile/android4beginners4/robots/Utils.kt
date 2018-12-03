package com.daftmobile.android4beginners4.robots

import android.app.AlertDialog
import android.content.Context

fun showMsgDialog(context: Context, msg: CharSequence) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage(msg)
    builder.setPositiveButton("OK") { _, _ -> }
    builder.show()
}
