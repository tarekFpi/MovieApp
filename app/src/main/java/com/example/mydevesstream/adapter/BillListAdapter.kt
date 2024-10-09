package com.example.mydevesstream.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevesstream.databinding.BillLayoutBinding
import com.example.mydevesstream.model.billModel



class billPayAdapter(private val context: Context,
                         private var billPayList: ArrayList<billModel>
                       ): RecyclerView.Adapter<billPayAdapter.MyviewHolder>() {



  inner class MyviewHolder(val binding: BillLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val binding = BillLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyviewHolder(binding)
    }

    fun setBillList(list: ArrayList<billModel>) {

        this.billPayList =list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = billPayList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val itemPosition = billPayList[position]

        holder.binding.textBillName.text =  itemPosition.name

        holder.binding.imageviewBill.setImageResource(itemPosition.image)

    }

}