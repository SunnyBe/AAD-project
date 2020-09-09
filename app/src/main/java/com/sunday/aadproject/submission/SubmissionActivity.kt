package com.sunday.aadproject.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sunday.aadproject.R
import com.sunday.aadproject.data.ServiceBuilder
import com.sunday.aadproject.data.SubmissionService
import com.sunday.aadproject.main.entity.SubmissionEntity
import com.sunday.aadproject.main.util.internetConnected
import com.sunday.aadproject.main.util.notEmpty
import com.sunday.aadproject.main.util.toastMsg
import kotlinx.android.synthetic.main.activity_submission.*
import kotlinx.android.synthetic.main.dialog_confirm.view.*
import kotlinx.android.synthetic.main.dialog_status.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmissionActivity : AppCompatActivity(R.layout.activity_submission) {

    lateinit var submissionService: SubmissionService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        submissionService = ServiceBuilder.buildService(
            baseUrl = "https://docs.google.com/forms/d/e/",
            service = SubmissionService::class.java
        )

        submitButton?.setOnClickListener {
            if (firstNameEntry.notEmpty() && lastNameEntry.notEmpty() && emailEntry.notEmpty() && githubLinkEntry.notEmpty()) {
                val submissionEntity = SubmissionEntity(
                    name = firstNameEntry.text.toString(),
                    lastName = lastNameEntry.text.toString(),
                    email = emailEntry.text.toString(),
                    github = githubLinkEntry.text.toString()
                )
                if (internetConnected()) confirmDialog(submissionEntity) else toastMsg(resources.getString(R.string.no_internet))
            } else toastMsg(resources.getString(R.string.wrong_entries))
        }
    }

    private fun confirmDialog(submissionEntity: SubmissionEntity) {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_confirm, null)
        val dialog = materialDialog(view).show()

        view.dialogSubmit?.setOnClickListener {
            dialog.dismiss()
            sendRequestToApi(
                submissionEntity.name,
                submissionEntity.lastName,
                submissionEntity.email,
                submissionEntity.github
            )
            presentDialog(true)
        }
    }

    private fun sendRequestToApi(name: String, lastName: String, email: String, github: String) {
        submissionService.submitProject(name, lastName, email, github)
            .enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    toastMsg(t.message ?: "")
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    toastMsg(response.body().toString())
                }

            })
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