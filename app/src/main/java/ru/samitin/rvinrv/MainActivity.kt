package ru.samitin.rvinrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.samitin.rvinrv.adapters.HorisontalRecyclerViewAdapter
import ru.samitin.rvinrv.adapters.VerticalRecyclerViewAdapter
import ru.samitin.rvinrv.adapters.models.HorisontalModel
import ru.samitin.rvinrv.adapters.models.VerticalModel
import ru.samitin.rvinrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null
    val arrayListVertical:ArrayList<VerticalModel>?=ArrayList<VerticalModel>()
    var adapter:VerticalRecyclerViewAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.recyclerview?.setHasFixedSize(true)
        binding?.recyclerview?.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        setData()
        adapter= VerticalRecyclerViewAdapter(this,arrayListVertical!!)
        binding?.recyclerview?.adapter=adapter
    }

    private fun setData() {
       for (i in 1..5){
           var verticalModel=VerticalModel("Title$i")
           var arrayListHorisontal=ArrayList<HorisontalModel>()
           for (j in 0..5){
               var horisontalModel=HorisontalModel("Name $j","Description $j")
               arrayListHorisontal.add(horisontalModel)
           }
           verticalModel.arrayList = arrayListHorisontal
           arrayListVertical?.add(verticalModel)
       }
        //adapter?.notifyDataSetChanged()
    }
}