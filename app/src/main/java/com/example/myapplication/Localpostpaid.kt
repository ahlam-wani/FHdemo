package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_localpostpaid.*


class Localpostpaid : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_localpostpaid, container, false)
        val imageView=view.findViewById<ImageView>(R.id.imageView13)
        imageView.setOnClickListener {
            imageView13.alpha==0.1f
            textView16.visibility=View.VISIBLE
            radio_group.visibility=View.VISIBLE
        }
        return view
    }



}