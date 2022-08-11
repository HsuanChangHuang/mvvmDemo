package com.ray.mvvmdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ray.mvvmdemo.databinding.ItemFlightsBinding
import com.ray.mvvmdemo.model.ShareModel
import com.ray.mvvmdemo.model.data.FlightModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class FlightAdapter (val listener: OnItemClickListener) : RecyclerView.Adapter<FlightAdapter.MyViewHolder>()  {
    val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd, MM, yyyy", Locale.US)

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
        val date = LocalDate.parse((flightList[position].launchDateLocal), inputFormatter)
        holder.itemFlightsBinding.tvLaunchDateLocal.text = outputFormatter.format(date)
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
