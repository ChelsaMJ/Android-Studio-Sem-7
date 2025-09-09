package com.example.animations

data class Student(
    val name: String,
    val rollNo: String,
    var status: AttendanceStatus = AttendanceStatus.NONE
)

enum class AttendanceStatus {
    NONE, PRESENT, ABSENT
}
