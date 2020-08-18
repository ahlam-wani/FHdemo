package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlankFragment3 : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_blank3, container, false)
          val text=v.findViewById<TextView>(R.id.txtMain)
        text.setText(R.string.Third_Fragment)
          val img=v.findViewById<ImageView>(R.id.imgMain)
        img.setImageResource(R.mipmap.ic_launcher)
        return v
    }



}