package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_international_prepaid.*
import kotlin.collections.ArrayList
class international_prepaid : AppCompatActivity(),callback {
    var dataList = ArrayList<Int>()
    lateinit var text: TextView
    lateinit var name:EditText
    lateinit var recyclerView: RecyclerView
    lateinit var rv3:RecyclerView
    lateinit var mobile:EditText
    lateinit var beneficiary:TextView
    lateinit var text2:TextView
    lateinit var bottomrecycler:RecyclerView
    var simlist=ArrayList<Int>()
    lateinit var benficiarieslist:ArrayList<Beneficiaries>
    lateinit var textInfo:TextView
     lateinit var button:ImageView
    lateinit var root:ConstraintLayout
    lateinit var transaction:LinearLayout
    lateinit var planRecharge:TextView
    lateinit var text2plan:TextView
    lateinit var billedtext:TextView
    lateinit var edt_payabletext:EditText
    var array= arrayOf("state","Andra Pradesh","Goa","J&K","Himachal Pradesh")
    lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_international_prepaid)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view2)
        rv3=findViewById(R.id.recycler_view3)
        textInfo=findViewById(R.id.text_top_info)
        mobile=findViewById(R.id.mobile_no)
        beneficiary=findViewById(R.id.text_beneficiary)
        text = findViewById(R.id.text2)
        text2=findViewById(R.id.text_22)
        name=findViewById(R.id.edt_name)
        spinner=findViewById(R.id.spinner)
        root= findViewById(R.id.root_layout)
          transaction=findViewById(R.id.layout_transaction)
        planRecharge=findViewById(R.id.plan_recharge)
        text2plan=findViewById(R.id.text_2plan)
        billedtext=findViewById(R.id.billed_amount_text)
        edt_payabletext=findViewById(R.id.edt_payable_text)

            button=findViewById(R.id.btn_click)
             val spinneradapter =ArrayAdapter(this,R.layout.spinner_layout,array)
                 spinneradapter.setDropDownViewResource(R.layout.spinner_layout)
             spinner.adapter=spinneradapter
          spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
              override fun onNothingSelected(parent: AdapterView<*>?) {


              }

              override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

              }

          }
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        dataList.add(R.drawable.ic_india)
        var adapter: RecycleAdap2 = RecycleAdap2(dataList,object :call{
            override fun onClick() {
                text.visibility=VISIBLE
                rv3.visibility= VISIBLE
            }

            override fun onClick2(position: String) {}
        })
        recyclerView.adapter = adapter
        rv3.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        simlist.add(R.drawable.airtel_logo)
        var adapter2=RecycleAdap3(simlist,object :call{
            override fun onClick() {
                textInfo.visibility= GONE
                recyclerView.visibility= GONE
                mobile.visibility= VISIBLE
                text2.visibility= VISIBLE
                beneficiary.visibility= VISIBLE

            }
            override fun onClick2(position: String) {}
        })
        rv3.adapter=adapter2
        beneficiary.setOnClickListener {
            bottomSheetDialog()
        }

    }
    private fun bottomSheetDialog(){
        val dialog=BottomSheetDialog(this,R.style.AppBottomSheetDialogTheme)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_,null)
        dialog.setContentView(view)
        bottomrecycler=view.findViewById(R.id.bottom_sheet_recycler)
        bottomrecycler.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        benficiarieslist=ArrayList<Beneficiaries>()
        benficiarieslist.add(Beneficiaries("+91-9845678325","20th March 2020"))
        benficiarieslist.add(Beneficiaries("+91-9845978325","20th March 2020"))
        benficiarieslist.add(Beneficiaries("+91-9245678325","20th March 2020"))
        benficiarieslist.add(Beneficiaries("+91-9345678325","20th March 2020"))
        var recyclerAdaterbottom=RecyclerAdapterBottomSheet(benficiarieslist,object :call{
            override fun onClick() {}
            override fun onClick2(position: String) {
                // Toast.makeText(this@international_prepaid, "you clicked $position",Toast.LENGTH_SHORT).show()
                mobile.setText(position)
                dialog.dismiss()
                 edt_name.visibility= VISIBLE
                  edt_name.setText("John Doe")
                    spinner.visibility= VISIBLE
                    btn_click.alpha= 1.0F
            }
        })
        bottomrecycler.adapter=recyclerAdaterbottom
        dialog.show()
        btn_click.setOnClickListener {
                 showFragment()
        }
    }
          fun showFragment(){
                             // root.visibility= INVISIBLE
                         supportFragmentManager.beginTransaction().add(R.id.root_layout,BlankFragment4()).commit()

          }
    interface call {
        fun onClick()
        fun onClick2(position: String)
    }

    override fun onClick(text: String) {
            transaction.visibility=VISIBLE
            planRecharge.text = text
            text2plan.text=text
             billedtext.text=text
            edt_payabletext.setText("34.90")


    }


}