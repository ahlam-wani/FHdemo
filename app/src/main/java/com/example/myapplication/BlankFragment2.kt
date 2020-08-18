package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v= inflater.inflate(R.layout.fragment_blank2, container, false)
        val textv=v.findViewById<TextView>(R.id.txtMain)
        textv.setText(R.string.Second_fragment)
        val img=v.findViewById<ImageView>(R.id.imgMain)
        img.setImageResource(R.mipmap.ic_launcher)
        return v
    }


}