package com.ray.mvvmdemo.utils

import androidx.recyclerview.widget.DiffUtil
import com.ray.mvvmdemo.model.data.FlightModel

class FlightDiffUtilCallback (private val oldList: List<FlightModel.flightModelItem>, private val newList: List<FlightModel.flightModelItem>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].flightNumber == newList[newItemPosition].flightNumber
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].flightNumber == newList[newItemPosition].flightNumber -> true
            oldList[oldItemPosition].missionName == newList[newItemPosition].missionName -> true
            else -> false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}