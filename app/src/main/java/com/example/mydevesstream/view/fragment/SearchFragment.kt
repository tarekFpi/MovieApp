package com.example.mydevesstream.view.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevesstream.R
import com.example.mydevesstream.adapter.CarListAdapter
import com.example.mydevesstream.adapter.billPayAdapter
import com.example.mydevesstream.adapter.transactionsAdater
import com.example.mydevesstream.model.billModel
import com.example.mydevesstream.model.transactionsModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var recyclerTrans: RecyclerView

    private lateinit var transAdapter : transactionsAdater
    private var transList: ArrayList<transactionsModel> = ArrayList()

    private lateinit var textView1:TextView

    private lateinit var textView2:TextView

    private lateinit var textView3:TextView

    private lateinit var textView4:TextView

    private lateinit var textView5:TextView

    private lateinit var textView6:TextView

    private var status:Boolean=false

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_search, container, false)

        recyclerTrans =view.findViewById(R.id.recyclerView_transactions)
        transAdapter= transactionsAdater(requireContext(),transList)

        recyclerTrans.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(requireContext())
            adapter=transAdapter
        }

        transList.add(transactionsModel(R.drawable.tns))
        transList.add(transactionsModel(R.drawable.tns))
        transList.add(transactionsModel(R.drawable.tns))
        transList.add(transactionsModel(R.drawable.tns))
        transAdapter.setTransList(transList)


        textView1 =view.findViewById(R.id.text1w)

        textView2 =view.findViewById(R.id.text1m)

        textView3 =view.findViewById(R.id.text3m)

        textView4 =view.findViewById(R.id.text6m)

        textView5 =view.findViewById(R.id.text1y)

        textView6 =view.findViewById(R.id.textAll)

        textView1.setBackgroundResource(R.drawable.chip_shap)
        textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

        textView1.setOnClickListener {

          textView1.setBackgroundResource(R.drawable.chip_shap)

         textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView2.setBackgroundResource(R.drawable.chip_color)
            textView3.setBackgroundResource(R.drawable.chip_color)
            textView4.setBackgroundResource(R.drawable.chip_color)
            textView5.setBackgroundResource(R.drawable.chip_color)
            textView6.setBackgroundResource(R.drawable.chip_color)

            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView4.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView5.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView6.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

        }

        textView2.setOnClickListener {

            textView2.setBackgroundResource(R.drawable.chip_shap)
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView1.setBackgroundResource(R.drawable.chip_color)
            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))


        }

        textView3.setOnClickListener {

            textView3.setBackgroundResource(R.drawable.chip_shap)
            textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView1.setBackgroundResource(R.drawable.chip_color)
            textView2.setBackgroundResource(R.drawable.chip_color)

            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

        }

        textView4.setOnClickListener {

            textView4.setBackgroundResource(R.drawable.chip_shap)
            textView4.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView1.setBackgroundResource(R.drawable.chip_color)
            textView2.setBackgroundResource(R.drawable.chip_color)
            textView3.setBackgroundResource(R.drawable.chip_color)

            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView6.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

        }

        textView5.setOnClickListener {

            textView5.setBackgroundResource(R.drawable.chip_shap)
            textView5.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView1.setBackgroundResource(R.drawable.chip_color)
            textView2.setBackgroundResource(R.drawable.chip_color)
            textView3.setBackgroundResource(R.drawable.chip_color)
            textView4.setBackgroundResource(R.drawable.chip_color)
            textView6.setBackgroundResource(R.drawable.chip_color)

            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView4.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView6.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

        }

        textView6.setOnClickListener {

            textView6.setBackgroundResource(R.drawable.chip_shap)
            textView6.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            textView1.setBackgroundResource(R.drawable.chip_color)
            textView2.setBackgroundResource(R.drawable.chip_color)
            textView3.setBackgroundResource(R.drawable.chip_color)
            textView4.setBackgroundResource(R.drawable.chip_color)
            textView5.setBackgroundResource(R.drawable.chip_color)

            textView1.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView2.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView3.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView4.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            textView5.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))


        }
        return view
    }




}