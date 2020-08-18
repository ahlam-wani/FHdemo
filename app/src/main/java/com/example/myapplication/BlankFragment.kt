package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_blank, container, false)

                var pre_international=view.findViewById<ImageView>(R.id.imageView3)
                international(pre_international)

        var localpostpaid=view.findViewById<ImageView>(R.id.imageView)

        localpostpaid.setOnClickListener {swapfragment()}
        return view
    }
    private fun international(pre_international:ImageView){
        pre_international.setOnClickListener {
              var intent=Intent(context,international_prepaid::class.java)
            startActivity(intent)
        }
    }
    private fun swapfragment(){
        var blankFragment=activity?.supportFragmentManager?.findFragmentById(R.id.blankfrag)
        blankFragment?.view?.visibility=View.INVISIBLE
       // var mainActivity: View? =activity?.findViewById(R.id.main_layout)
        //mainActivity?.visibility=View.INVISIBLE
         var localpostpaid=Localpostpaid()
        var blank4=BlankFragment4()

          var fragmentTransaction=activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.main_layout,blank4)?.addToBackStack("null")?.commit()

    }
}



