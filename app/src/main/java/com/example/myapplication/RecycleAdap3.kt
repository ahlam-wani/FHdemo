package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdap3(var simlist:ArrayList<Int>,val listener:international_prepaid.call) :RecyclerView.Adapter<RecycleAdap3.ViewHolder>(){


    inner  class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


          fun bindItems(user:Int) {
              var airtel=itemView.findViewById<ImageView>(R.id.img_airtel)
              var bsnl=itemView.findViewById<ImageView>(R.id.img_bsnl)
              var vodafone=itemView.findViewById<ImageView>(R.id.img_voda)
              var idea=itemView.findViewById<ImageView>(R.id.img_idea)
                   airtel.setImageResource(R.drawable.airtel_logo)
                    bsnl.setImageResource(R.drawable.bsnl_logo)
                     vodafone.setImageResource(R.drawable.vodafone_logo)
                      idea.setImageResource(R.drawable.idea_logo)
                      airtel.setOnClickListener {
                     bsnl.visibility=View.GONE
                     vodafone.visibility=View.GONE
                      idea.visibility=View.GONE
                      listener.onClick()
              }
          }
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
              val v=LayoutInflater.from(parent.context).inflate(R.layout.simlistrv2,parent,false)
               return ViewHolder(v)

    }
    override fun getItemCount(): Int {
                   return simlist.size
        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bindItems(simlist[position])
        }
}