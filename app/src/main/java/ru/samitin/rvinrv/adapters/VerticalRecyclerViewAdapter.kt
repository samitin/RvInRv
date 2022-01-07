package ru.samitin.rvinrv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.samitin.rvinrv.R
import ru.samitin.rvinrv.adapters.models.HorisontalModel
import ru.samitin.rvinrv.adapters.models.VerticalModel

class VerticalRecyclerViewAdapter(val context:Context,var arrayList:ArrayList<VerticalModel>):
    RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRVViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_vertical,parent,false)
        return VerticalRVViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerticalRVViewHolder, position: Int) {
        val verticalModel=arrayList.get(position)
        val title=verticalModel.title
        val singleItem : ArrayList<HorisontalModel> = verticalModel.arrayList!!
        holder.textTitle1.text=title
        val horisontalrecyclerViewAdapter=HorisontalRecyclerViewAdapter(context,singleItem)
        holder.recyclerView1.setHasFixedSize(true)
        holder.recyclerView1.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.recyclerView1.adapter=horisontalrecyclerViewAdapter
        holder.btnMore.setOnClickListener {
            Toast.makeText(context,verticalModel.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class VerticalRVViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textTitle1:TextView
        val recyclerView1:RecyclerView
        val btnMore:Button
        init {
            textTitle1=itemView.findViewById<TextView>(R.id.textTitle1)
            recyclerView1=itemView.findViewById<RecyclerView>(R.id.recyclerview1)
            btnMore=itemView.findViewById<Button>(R.id.btnMore)
        }
    }
}