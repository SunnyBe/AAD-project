package com.sunday.aadproject.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sunday.aadproject.R
import kotlinx.android.synthetic.main.activity_submission.*
import kotlinx.android.synthetic.main.dialog_confirm.view.*
import kotlinx.android.synthetic.main.dialog_status.view.*

class SubmissionActivity : AppCompatActivity(R.layout.activity_submission) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        submitButton?.setOnClickListener {
            // Todo Submit form data
            confirmDialog()
//            presentDialog(false)
        }
    }

    private fun confirmDialog() {
        // Failed submission
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_confirm, null)
        val dialog = materialDialog(view).show()

        view.dialogSubmit?.setOnClickListener {
            dialog.dismiss()
            // Todo: Send request to Api
//            sendRequestToApi(firstName, lastName, email, githubLink)
            presentDialog(true)
        }
    }

    private fun presentDialog(success: Boolean) {
        val view = if (success) {
            LayoutInflater.from(this).inflate(R.layout.dialog_status, null).apply {
                statusIcon?.setImageResource(R.drawable.ic_launch)
                statusMsg?.text = "Submission Successful"
            }
        } else {
            LayoutInflater.from(this).inflate(R.layout.dialog_status, null).apply {
                statusIcon?.setImageResource(R.drawable.ic_launch)
                statusMsg?.text = "Submission was not successful"
            }
        }
        materialDialog(view).show()
    }

    private fun materialDialog(view: View): MaterialAlertDialogBuilder {
        return MaterialAlertDialogBuilder(this)
            .setView(view)
    }
}