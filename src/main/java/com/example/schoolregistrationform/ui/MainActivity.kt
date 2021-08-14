package com.example.registeringapplication.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myposts.R
import com.example.registeringapplication.api.ApiClient
import com.example.registeringapplication.api.ApiInterface
import com.example.registeringapplication.models.RegistrationRequest
import com.example.registeringapplication.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var etJin: EditText
    lateinit var etDob: EditText
    lateinit var etnationality: Spinner
    lateinit var etIdNumber: EditText
    lateinit var etPhoneNumber : EditText
    lateinit var etEmail: EditText
    lateinit var btnRegister: Button
    lateinit var progress:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()


        etJin=findViewById(R.id.etJin)
        etDob=findViewById(R.id.etDob)
        etnationality=findViewById(R.id.spinner)
        etIdNumber=findViewById(R.id.etId)
        etPhoneNumber=findViewById(R.id.etPhone)
        etEmail=findViewById(R.id.etEmail)
        btnRegister=findViewById(R.id.btnRegister)
        progress=findViewById(R.id.progressBar)

        btnRegister.setOnClickListener {
            var name = etJin.text.toString()
            if (name.isEmpty()){
                etJin.setError("enter name")

            }
            progress.visibility
            var nationality = etnationality.selectedItem.toString().toUpperCase()
            if (nationality.isEmpty()){

            }

            var dob= etDob.text.toString()
            if (dob.isEmpty()){
                etJin.setError("enter Date of birth")
            }

            var IdNumber= etIdNumber.text.toString()
            if (IdNumber.isEmpty()){
                etIdNumber.setError("Enter Id number")
            }
            var phoneNumber= etPhoneNumber.text.toString()
            if (phoneNumber.isEmpty()){
                etPhoneNumber.setError("Enter phone number")
            }
            var email = etEmail.text.toString()
            if(email.isEmpty()){
                etEmail.setError("enter email")
            }
            //var details = Details(name, dob, IdNumber, phoneNumber, email)
            val intent= Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
            var regRequest=RegistrationRequest(name = name,password = IdNumber, phoneNumber = phoneNumber,email = email,
                    DOB = dob,nationality = nationality
            )
            var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
            var request= retrofit.registerStudent(regRequest)
            request.enqueue(object : Callback<RegistrationResponse> {

                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "Your registration is successful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    fun castViews(){

        etJin = findViewById(R.id.etJin)
        etDob= findViewById(R.id.etDob)
        etnationality= findViewById(R.id.spinner)
        etIdNumber= findViewById(R.id.etId)
        etPhoneNumber = findViewById(R.id.etPhone)
        etEmail= findViewById(R.id.etPhone)
        btnRegister= findViewById(R.id.btnRegister)

        var nationalities= arrayListOf("Kenyan","Rwandan","SouthSudanese","Sudanese","Rwandan","Ugandan")
        var nationalitiesAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        etnationality.adapter=nationalitiesAdapter



    }


}
