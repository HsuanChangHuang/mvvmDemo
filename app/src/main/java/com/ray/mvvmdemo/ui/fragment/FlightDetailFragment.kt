package com.ray.mvvmdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.ray.mvvmdemo.*
import com.ray.mvvmdemo.databinding.FragmentFlightDetailBinding
import com.ray.mvvmdemo.model.ShareModel
import com.ray.mvvmdemo.model.data.FlightModel
import com.ray.mvvmdemo.utils.TimeUtils

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

        binding.clCores.setOnClickListener {
            showMoreCores()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareModel.flightItem.observe(requireActivity(), Observer {
            if(it != null){
                showViewData(it)
            }
        })
    }

    private fun showViewData(data: FlightModel.flightModelItem){
        context?.let { context -> Glide.with(context).load(data.links.missionPatchSmall).into(binding.ivLaunchPostion) }
        binding.tvFlightNumber.text = data.flightNumber.toString()
        binding.tvMissionName.text = data.missionName
        binding.tvLaunchDate.text = TimeUtils.getTimeFormat(data.launchDateLocal)
        binding.tvLaunchSite.text = data.launchSite.siteName

        binding.tvCoreSerial.text = data.rocket.firstStage.cores[0].coreSerial.toString()
        val block = data.rocket.firstStage.cores[0].block
        if (block == 0){
            binding.tvCoresBlock.text = activity?.getString(R.string.flight_no_info)
        }else{
            binding.tvCoresBlock.text = block.toString()
        }
        binding.tvCoresFlight.text = data.rocket.firstStage.cores[0].flight.toString()

        val resued = data.rocket.firstStage.cores[0].reused as Boolean
        if (resued){
            binding.tvCoresReused.text = activity?.getString(R.string.yes)
        }else{
            binding.tvCoresReused.text = activity?.getString(R.string.no)
        }

        val landing = data.rocket.firstStage.cores[0].landingType
        if (landing == null){
            binding.tvCoresLanding.text =  activity?.getString(R.string.flight_no_info)
        }else{
            binding.tvCoresLanding.text = landing.toString()
        }
    }

    private fun showMoreCores(){
        if (binding.clExpand.visibility == View.GONE){
            binding.ivExpand.setBackgroundResource(R.drawable.baseline_keyboard_arrow_down_black_24)
            TransitionManager.beginDelayedTransition(binding.cdCores, AutoTransition())
            binding.clExpand.visibility = View.VISIBLE
        }else{
            binding.ivExpand.setBackgroundResource(R.drawable.baseline_expand_less_black_24)
            TransitionManager.beginDelayedTransition(binding.cdCores, AutoTransition())
            binding.clExpand.visibility = View.GONE
        }
    }
}