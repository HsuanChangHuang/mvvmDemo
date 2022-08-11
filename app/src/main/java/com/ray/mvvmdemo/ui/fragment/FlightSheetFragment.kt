package com.ray.mvvmdemo.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ray.mvvmdemo.*
import com.ray.mvvmdemo.databinding.FragmentFlightSheetBinding
import com.ray.mvvmdemo.model.ShareModel
import com.ray.mvvmdemo.model.data.FlightModel

class FlightSheetFragment(val listener: OnFilterListener): BottomSheetDialogFragment(){
    companion object {
        const val TAG = "FlightSheetFragment"
    }
    private lateinit var binding: FragmentFlightSheetBinding
    private lateinit var navController: NavController
    private lateinit var shareModel: ShareModel
    private var filter = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_sheet, container, false)
        navController = findNavController()
        shareModel = ViewModelProvider(requireActivity())[ShareModel::class.java]

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.doOnPreDraw {
            (dialog as BottomSheetDialog).behavior.peekHeight = view.height
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        var select = binding.rgFilter.checkedRadioButtonId == binding.rbNewest.id
        if (filter != select){
            filter = select
            listener.OnFilterChange(filter)
//            shareModel.listFilter.postValue(filter)
        }
        super.onDismiss(dialog)
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }

    interface OnFilterListener{
        fun OnFilterChange(filter: Boolean)
    }
}