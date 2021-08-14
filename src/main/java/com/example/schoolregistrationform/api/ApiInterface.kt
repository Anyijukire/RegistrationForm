package com.example.registeringapplication.api

import com.example.registeringapplication.models.RegistrationRequest
import com.example.registeringapplication.models.RegistrationResponse
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>
    @GET("students/login")
    fun loginStudent(@Body logInRequest: LogInRequest):Call<LogInResponse>
}
