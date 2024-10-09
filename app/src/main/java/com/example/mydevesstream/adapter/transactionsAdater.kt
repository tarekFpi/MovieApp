package com.example.mydevesstream.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevesstream.databinding.TransLayoutBinding
import com.example.mydevesstream.model.transactionsModel


class transactionsAdater(private val context: Context,
                     private var transList: ArrayList<transactionsModel>
): RecyclerView.Adapter<transactionsAdater.MyviewHolder>() {



    inner class MyviewHolder(val binding: TransLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val binding = TransLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyviewHolder(binding)
    }

    fun setTransList(list: ArrayList<transactionsModel>) {

        this.transList =list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = transList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val itemPosition = transList[position]

        holder.binding.imageTrans.setImageResource(itemPosition.image)
    }

}