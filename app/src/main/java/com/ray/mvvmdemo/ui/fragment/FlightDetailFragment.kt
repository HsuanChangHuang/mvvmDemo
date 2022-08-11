package com.ray.mvvmdemo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ray.mvvmdemo.*
import com.ray.mvvmdemo.databinding.FragmentFlightDetailBinding
import com.ray.mvvmdemo.model.ShareModel

class FlightDetailFragment : Fragment(){
    companion object {
        const val TAG = "FlightDetailFragment"
    }
    private lateinit var binding: FragmentFlightDetailBinding
    private lateinit var navController: NavController
    private lateinit var shareModel: ShareModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_detail, container, false)

        navController = findNavController()
        shareModel = ViewModelProvider(requireActivity())[ShareModel::class.java]


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareModel.flightItem.observe(requireActivity(), Observer {
            Log.d(FlightListFragment.TAG, "onClick: ${it.flightNumber}")
        })
    }
}