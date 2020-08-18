package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.tab_bar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager=findViewById<ViewPager>(R.id.viewPager)
        tv_pay.setOnClickListener { viewPager.currentItem = 0 }
        tv_request.setOnClickListener { viewPager.currentItem=1 }
        tv_manage.setOnClickListener { viewPager.currentItem=2  }

        if (viewPager!=null)
        {
             val adapter=ViewPagerAdapter(supportFragmentManager)
            viewPager.adapter=adapter
        }

        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                onPageChange(position)

            }
        })
}
    fun onPageChange(position:Int){
        when(position){
            0->{tv_pay.setBackgroundResource(R.drawable.bg_blue)
               tv_request.setBackgroundResource(R.drawable.bg_disable_grey)
                tv_manage.setBackgroundResource(R.drawable.bg_disable_grey)}
            1->{tv_pay.setBackgroundResource(R.drawable.bg_disable_grey)
                tv_request.setBackgroundResource(R.drawable.bg_blue)
                tv_manage.setBackgroundResource(R.drawable.bg_disable_grey)}
            2->{tv_pay.setBackgroundResource(R.drawable.bg_disable_grey)
                tv_request.setBackgroundResource(R.drawable.bg_disable_grey)
                tv_manage.setBackgroundResource(R.drawable.bg_blue)}
        }
    }
}