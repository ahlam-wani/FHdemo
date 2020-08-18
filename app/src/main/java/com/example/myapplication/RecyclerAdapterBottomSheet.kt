package com.example.myapplication

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterBottomSheet (var beneficiarieslist:ArrayList<Beneficiaries>,val listener:international_prepaid.call):RecyclerView.Adapter<RecyclerAdapterBottomSheet.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterBottomSheet.ViewHolder {
    val v=LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet_recyclerview_layout,parent,false)
          return ViewHolder(v)
    }

    override fun getItemCount(): Int {
                return beneficiarieslist.size
        }

    override fun onBindViewHolder(holder: RecyclerAdapterBottomSheet.ViewHolder, position: Int) {
                   holder.bindItems(beneficiarieslist[position])

        }
      inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
               fun bindItems(beneferies:Beneficiaries){
                       var log=itemView.findViewById<ImageView>(R.id.img_airtel_logo_1)
                       var number=itemView.findViewById<TextView>(R.id.number)
                       var date=itemView.findViewById<TextView>(R.id.date)
                       var options= itemView.findViewById<ImageView>(R.id.img_optionsmenu)

                       log.setImageResource(R.drawable.airtel_logo_)
                       number.text=beneferies.number
                       date.text=beneferies.date
                        options.setImageResource(R.drawable.ic_baseline_more_vert_24)
                       options.setOnClickListener {
                           var popup=PopupWindow(this.itemView.context)
                           var layout= LinearLayout(this.itemView.context)
                           var text=TextView(this.itemView.context)
                              showPopup(popup,layout,text)
                                                    }
                                  itemView.setOnClickListener {
                                            listener.onClick2(number.text.toString())
                                  }
               }
                     fun showPopup(popup:PopupWindow,layout: LinearLayout,textView: TextView){
                            var click:Boolean=true
                            if (click){
                         popup.showAtLocation(layout,Gravity.RIGHT,2,2)
                          popup.update(10,20)
                               click=false
                            }
                         else
                                 popup.dismiss()
                         click  =  true
                         val popup=PopupMenu(this.itemView.context,itemView)
                         popup.menuInflater.inflate(R.menu.menu,popup.menu)
                         popup.show()
                           //  var params=LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                             //    ViewGroup.LayoutParams.WRAP_CONTENT)
                         //   layout.orientation=LinearLayout.VERTICAL
                           //     textView.text="Delete"
                             //  layout.addView(textView,params)
                              // popup.contentView=layout
                     }
      }



}

