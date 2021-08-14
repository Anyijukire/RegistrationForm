package com.example.registeringapplication.ui

import android.app.Activity
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.R
import com.example.registeringapplication.models.Course

class CoursesActivity : AppCompatActivity() {
    lateinit var rvCourses: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        var courseList= listOf(Course("Kotlin","John",34,
                "building Android applications"),
                Course("python","Jamo",4,"Making the backend")
        )
        rvCourses = findViewById(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val recyclerAdapter = CoursesAdapter(courseList)
        rvCourses.adapter = recyclerAdapter
    }
}
