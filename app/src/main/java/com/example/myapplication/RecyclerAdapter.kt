package com.example.myapplication
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerAdapter(val userList: ArrayList<Plans>,val listener:callback) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v1 = LayoutInflater.from(parent.context).inflate(R.layout.list_latout, parent, false)
        return ViewHolder(v1)
    }
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }
    override fun getItemCount(): Int {
        return userList.size
    }
   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
             fun bindItems(user: Plans) {
            val textViewName = itemView.findViewById(R.id.inr_658) as TextView
            val textViewAddress  = itemView.findViewById(R.id.inr_658_info) as TextView
            textViewName.text = user.balance
            textViewAddress.text = user.textinfo
                   itemView.setOnClickListener {
                              listener.onClick(textViewName.text.toString())
                   }
        }
    }
}
