package com.example.mydevesstream.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mydevesstream.R
import com.example.mydevesstream.adapter.CarListAdapter
import com.example.mydevesstream.adapter.billPayAdapter
import com.example.mydevesstream.model.billModel
import com.example.mydevesstream.model.carModel
import dagger.hilt.android.AndroidEntryPoint


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var billAdapter : billPayAdapter

    private lateinit var recyclerBillList: RecyclerView

    private lateinit var recyclerCarList: RecyclerView

    private lateinit var carAdapter : CarListAdapter
    private var billList: ArrayList<billModel> = ArrayList()

    private var carList: ArrayList<carModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_home, container, false)


        recyclerBillList =view.findViewById(R.id.recyclerView_billPayment)
        billAdapter= billPayAdapter(requireContext(),billList)

        recyclerBillList.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            adapter=billAdapter
        }


        billList.add(billModel(R.drawable.s1,"Electricity \n Bill"))
        billList.add(billModel(R.drawable.s2,"Internet \n Recharge"))
        billList.add(billModel(R.drawable.s3,"Cable \n Bill"))
        billList.add(billModel(R.drawable.s4,"Mobile \n Bill"))
        billAdapter.setBillList(billList)


        recyclerCarList =view.findViewById(R.id.recyclerView_car)
        carAdapter= CarListAdapter(requireContext(),carList)

        recyclerCarList.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            adapter=carAdapter
        }
        carList.add(carModel(R.drawable.phone))
        carList.add(carModel(R.drawable.phone))
        carList.add(carModel(R.drawable.phone))
        carList.add(carModel(R.drawable.phone))
        carAdapter.setCarList(carList)



        val imageSlider =view.findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.slider1))
        imageList.add(SlideModel(R.drawable.slider1))
        imageList.add(SlideModel(R.drawable.slider1))
        imageList.add(SlideModel(R.drawable.slider1))

        imageSlider.setImageList(imageList)
        return view
    }

}