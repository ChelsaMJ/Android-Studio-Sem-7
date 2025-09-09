package com.example.animations

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animations.databinding.ItemStudentBinding

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.binding.apply {
            tvName.text = student.name
            tvRoll.text = student.rollNo

            // Update UI based on status
            when (student.status) {
                AttendanceStatus.NONE -> {
                    btnMark.text = "MARK"
                    btnMark.setBackgroundColor(Color.BLACK)
                    tvName.setTextColor(Color.BLACK)
                    tvRoll.setTextColor(Color.BLACK)
                }
                AttendanceStatus.PRESENT -> {
                    btnMark.text = "PRESENT"
                    btnMark.setBackgroundColor(Color.GREEN)
                    tvName.setTextColor(Color.GREEN)
                    tvRoll.setTextColor(Color.GREEN)
                }
                AttendanceStatus.ABSENT -> {
                    btnMark.text = "ABSENT"
                    btnMark.setBackgroundColor(Color.RED)
                    tvName.setTextColor(Color.RED)
                    tvRoll.setTextColor(Color.RED)
                }
            }

            // Toggle button click
            btnMark.setOnClickListener {
                student.status = when (student.status) {
                    AttendanceStatus.NONE -> AttendanceStatus.PRESENT
                    AttendanceStatus.PRESENT -> AttendanceStatus.ABSENT
                    AttendanceStatus.ABSENT -> AttendanceStatus.NONE
                }
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int = students.size
}
