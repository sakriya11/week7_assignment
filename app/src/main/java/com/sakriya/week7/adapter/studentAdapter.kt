package com.sakriya.week7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sakriya.week7.model.Student

class StudentAdapter(val lstStudent: ArrayList<Student>,val context: Context) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val ivDelete: ImageView

        init {

            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            ivDelete = view.findViewById(R.id.delete)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mero_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder:StudentViewHolder, position: Int) {

        val student = lstStudent[position]

        holder.tvName.text = student.studentName
        holder.tvAge.text = student.studentAge.toString()
        holder.tvAddress.text = student.studentAddress
        holder.tvGender.text = student.studentGender




        holder.ivDelete.setOnClickListener {
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {

        return lstStudent.size
    }
}