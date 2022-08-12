package com.ray.mvvmdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ray.mvvmdemo.databinding.ItemFlightsBinding
import com.ray.mvvmdemo.model.data.FlightModel
import com.ray.mvvmdemo.utils.FlightDiffUtilCallback
import com.ray.mvvmdemo.utils.TimeUtils

class FlightAdapter (val listener: OnItemClickListener) : RecyclerView.Adapter<FlightAdapter.MyViewHolder>()  {
    var flightList: List<FlightModel.flightModelItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(val itemFlightsBinding: ItemFlightsBinding) :
        RecyclerView.ViewHolder(itemFlightsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding =
            ItemFlightsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemFlightsBinding.tvFlightNumber.text = flightList[position].flightNumber.toString()
        holder.itemFlightsBinding.tvMissionName.text = flightList[position].missionName
        holder.itemFlightsBinding.tvLaunchDateLocal.text = TimeUtils.getTimeFormat(flightList[position].launchDateLocal)
        Glide.with(holder.itemView.context).load(flightList[position].links.missionPatchSmall).into(holder.itemFlightsBinding.ivFlight)
        holder.itemFlightsBinding.itemFlight.setOnClickListener {
            listener.onItemClick(flightList[position])
        }
    }

    override fun getItemCount(): Int {
        return flightList.size
    }

    interface OnItemClickListener{
        fun onItemClick(item : FlightModel.flightModelItem)
    }

    fun sortByFlightNumber(isNewest: Boolean) {
        var updatedList = if (isNewest){
            flightList.sortedBy { it.flightNumber }
        }else{
            flightList.sortedByDescending { it.flightNumber }
        }
        val diffResult = DiffUtil.calculateDiff(FlightDiffUtilCallback(flightList, updatedList))
        flightList = updatedList
        diffResult.dispatchUpdatesTo(this)
    }
}
