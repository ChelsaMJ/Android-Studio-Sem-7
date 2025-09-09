package com.example.animations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animations.databinding.ActivityStudentAttendanceBinding

class StudentAttendanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentAttendanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentAttendanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentList = listOf(
            Student("Alice", "Roll 1"),
            Student("Bob", "Roll 2"),
            Student("Charlie", "Roll 3"),
            Student("David", "Roll 4"),
            Student("Eva", "Roll 5"),
            Student("Frank", "Roll 6")
        )

        val adapter = StudentAdapter(studentList)
        binding.rvStudents.layoutManager = GridLayoutManager(this, 2)
        binding.rvStudents.adapter = adapter

    }
}
