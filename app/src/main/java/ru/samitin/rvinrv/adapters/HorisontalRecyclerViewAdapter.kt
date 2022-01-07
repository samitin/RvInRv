package ru.samitin.rvinrv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.samitin.rvinrv.R
import ru.samitin.rvinrv.adapters.models.HorisontalModel

class HorisontalRecyclerViewAdapter(val context:Context,val arrayList: ArrayList<HorisontalModel>) :
    RecyclerView.Adapter<HorisontalRecyclerViewAdapter.HorisontalViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorisontalViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_horisontal,parent,false)
        return HorisontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorisontalViewHolder, position: Int) {
        val horisontalModel=arrayList.get(position)
        holder.textViewTitle.text=horisontalModel.name
        holder.itemView.setOnClickListener {
            Toast.makeText(context,horisontalModel.name,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class HorisontalViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textViewTitle:TextView
        val imageView:ImageView
        init {
            textViewTitle=itemView.findViewById<TextView>(R.id.textTitleHorisontal)
            imageView=itemView.findViewById<ImageView>(R.id.ivThamb)
        }
    }
}