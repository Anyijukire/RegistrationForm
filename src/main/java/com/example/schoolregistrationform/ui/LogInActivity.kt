package com.example.schoolregistrationform.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myposts.R
import com.example.registeringapplication.api.ApiClient
import com.example.registeringapplication.api.ApiInterface
import com.example.registeringapplication.models.RegistrationRequest
import com.example.registeringapplication.models.RegistrationResponse
import com.example.registeringapplication.ui.CoursesActivity
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var emaill:EditText
    lateinit var passs:EditText
    lateinit var buttonn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        emaill=findViewById(R.id.emaill)
        passs=findViewById(R.id.passs)
        buttonn=findViewById(R.id.button)

        buttonn.setOnClickListener {
            var email = emaill.text.toString()
            if (email.isEmpty()){
                emaill.setError("enter name")
            }
            var pass = passs.text.toString()
            if (pass.isEmpty()){
                passs.setError("enter name")
            }
            var logRequest=
                LogInRequest(email = email, password = pass
            )
            var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
            var request= retrofit.loginStudent(logRequest)
            request.enqueue(object : Callback<LogInResponse> {

                override fun onResponse(call: Call<LogInResponse>, response: Response<LogInResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "Your log in is successful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }

    }
}
