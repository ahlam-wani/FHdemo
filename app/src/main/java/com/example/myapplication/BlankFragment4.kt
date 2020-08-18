package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

class BlankFragment4 : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var recycleAdap:RecycleAdap2
    lateinit var onCall:callback
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_blank4, container, false)
               recyclerView=v.findViewById(R.id.recycler_view)
               recyclerView.layoutManager=LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)
       // var divider=DividerItemDecoration(recyclerView.context,DividerItemDecoration.HORIZONTAL)
        //divider.setDrawable(ContextCompat.getDrawable(v.context,R.drawable.vertical_divider)!!)
        //recyclerView.addItemDecoration(divider)
        recyclerView.addItemDecoration(SimpleItemDecorator(v.context))
               var plans=ArrayList<Plans>()
              plans.add(Plans("INR 699","Rs 000 plan description and brief"))
              plans.add(Plans("INR 000","Rs 000 plan description and brief"))
              plans.add(Plans("INR 000","Rs 000 plan description and brief"))
              plans.add(Plans("INR 000","Rs 000 plan description and brief"))
              plans.add(Plans("INR 000","Rs 000 plan description and brief"))
        plans.add(Plans("INR 000","Rs 000 plan description and brief"))
        var adapter: RecyclerAdapter =RecyclerAdapter(plans,object:callback{
            override fun onClick(text: String) {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this@BlankFragment4)?.commit()
                                            onCall.onClick(text)
                 }

        })
         recyclerView.adapter=adapter
         return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onCall=context as callback
        }catch (e:ClassCastException){}
    }

}
class SimpleItemDecorator : RecyclerView.ItemDecoration {
      private var mdivider: Drawable
    constructor(context:Context) {
        this.mdivider=context.resources.getDrawable(R.drawable.vertical_divider)
    }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        var left:Int= 22
        var right:Int=parent.width-(parent.width-24)
        var childcount=parent.childCount
        for (i in 0 until childcount-1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
           val top = child.top - (params.bottomMargin - 67)
            val bottom: Int = top +  mdivider.intrinsicHeight
            mdivider.setBounds(left, top, right, bottom)
            mdivider.draw(c)
        }
        }

    }
interface callback{
    fun onClick(text:String)
}
