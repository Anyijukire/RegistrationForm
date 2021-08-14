package com.example.registeringapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.R
import com.example.registeringapplication.models.Course

class CoursesAdapter(var courseList: List<Course>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.courses_resource_file,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.tvCourseName.text=currentCourse.name
        holder.tvCourseCode.text=currentCourse.code.toString()
        holder.tvCourseDescription.text=currentCourse.description
        holder.tvCourseInstructor.text=currentCourse.trainer

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseName=itemView.findViewById<TextView>(R.id.textView)
    var tvCourseCode=itemView.findViewById<TextView>(R.id.textView2)
    var tvCourseDescription=itemView.findViewById<TextView>(R.id.textView3)
    var tvCourseInstructor=itemView.findViewById<TextView>(R.id.textView4)



}
