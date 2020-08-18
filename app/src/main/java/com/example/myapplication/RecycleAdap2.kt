package com.example.myapplication


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView


class RecycleAdap2(val countryList: ArrayList<Int>,val listener:international_prepaid.call) : RecyclerView.Adapter<RecycleAdap2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdap2.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: RecycleAdap2.ViewHolder, position: Int) {

        holder.bindItems(countryList[position])
    }
    override fun getItemCount(): Int {
        return countryList.size
    }
   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        lateinit var  imageView: ImageView
        lateinit var image_pak:ImageView
        lateinit var imageSaudi:ImageView

       fun bindItems(user: Int) {
            imageView=itemView.findViewById<ImageView>(R.id.img_india)
             image_pak=itemView.findViewById<ImageView>(R.id.img_pak)
             imageSaudi=itemView.findViewById<ImageView>(R.id.img_saudi)
              imageView.setImageResource(R.drawable.ic_india)
             image_pak.setImageResource(R.drawable.ic_pakistan)
             imageSaudi.setImageResource(R.drawable.ic_saudi_arabia)
                imageView.setOnClickListener {
                       imageView.setImageResource(R.drawable.ic_india_)
                         image_pak.visibility=View.INVISIBLE
                         imageSaudi.visibility=View.INVISIBLE
                                 listener.onClick()


                }
       }
   }
}




