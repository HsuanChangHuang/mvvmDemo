package com.ray.mvvmdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ray.mvvmdemo.*
import com.ray.mvvmdemo.databinding.FragmentFlightListBinding
import com.ray.mvvmdemo.model.ShareModel
import com.ray.mvvmdemo.model.data.FlightModel

class FlightListFragment : Fragment(), FlightAdapter.OnItemClickListener, FlightSheetFragment.OnFilterListener {
    companion object {
        const val TAG = "FlightListFragment"
    }
    private lateinit var binding: FragmentFlightListBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: MainViewModel
    private lateinit var shareModel: ShareModel
    private lateinit var adapter: FlightAdapter
    private val retrofitService = RetrofitService.getInstance()
    private val flightSheetFragment = FlightSheetFragment(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_list, container, false)

        navController = findNavController()
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService)))[MainViewModel::class.java]
        shareModel = ViewModelProvider(requireActivity())[ShareModel::class.java]
        adapter = FlightAdapter(this)
        binding.rvFlight.adapter = adapter
        viewModel.getAllFlights()

        binding.btnFliter.setOnClickListener {
            if (!flightSheetFragment.isAdded){
                flightSheetFragment.show(this.parentFragmentManager,flightSheetFragment.tag)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.flightList.observe(requireActivity(), Observer {
            adapter.flightList = it
        })
        viewModel.errorMessage.observe(requireActivity(), Observer {
            Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
        })
        viewModel.loading.observe(requireActivity(), Observer {
            if (it){
                binding.pbFlight.visibility = View.VISIBLE
            }else{
                binding.pbFlight.visibility = View.GONE
            }
        })

//        shareModel.listFilter.observe(requireActivity(), Observer {
//            if (it){
//                binding.tvFilter.text = getString(R.string.flight_filter_newest)
//            }else{
//                binding.tvFilter.text = getString(R.string.flight_filter_oldest)
//            }
//            adapter.sortByFlightNumber(it)
//        })
    }

    override fun onItemClick(item: FlightModel.flightModelItem) {
        shareModel.flightItem.postValue(item)
        navController.navigate(R.id.flightDetailFragment)
    }

    override fun OnFilterChange(filter: Boolean) {
        if (filter){
            binding.tvFilter.text = getString(R.string.flight_filter_newest)
        }else{
            binding.tvFilter.text = getString(R.string.flight_filter_oldest)
        }
        adapter.sortByFlightNumber(filter)
    }
}