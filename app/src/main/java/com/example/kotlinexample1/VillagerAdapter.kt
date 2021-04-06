package com.example.kotlinexample1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VillagerAdapter (private val dataset:List<Villager>) : RecyclerView.Adapter<VillagerAdapter.ItemViewHolder>() {



     class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.textView_name)
        val textViewBirthday: TextView = view.findViewById(R.id.textView_birthday) 
        val textViewPhrase: TextView = view.findViewById(R.id.textView_phrase)
        val imageViewVillager: ImageView = view.findViewById(R.id.imageView_villager)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_villager, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var villager:Villager = dataset[position]
        holder.textViewName.text = villager.name
        holder.textViewBirthday.text = villager.birthday
        holder.textViewPhrase.text = villager.phrase


        holder.imageViewVillager.setOnClickListener{
            villager.showHouse = !villager.showHouse
            notifyDataSetChanged()
        }
        if(villager.showHouse){
            Picasso.get().load(villager.villagerUrl).into(holder.imageViewVillager)
        }else{
            Picasso.get().load(villager.houseURL).into(holder.imageViewVillager)
        }



    }
}





