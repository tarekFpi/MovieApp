package com.example.mydevesstream.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevesstream.databinding.BillLayoutBinding
import com.example.mydevesstream.databinding.CarLayoutBinding
import com.example.mydevesstream.model.billModel
import com.example.mydevesstream.model.carModel


class CarListAdapter(private val context: Context,
                     private var carList: ArrayList<carModel>
): RecyclerView.Adapter<CarListAdapter.MyviewHolder>() {



    inner class MyviewHolder(val binding: CarLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val binding = CarLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyviewHolder(binding)
    }

    fun setCarList(list: ArrayList<carModel>) {

        this.carList =list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = carList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val itemPosition = carList[position]
        
        holder.binding.imageviewCar.setImageResource(itemPosition.image)
    }

}