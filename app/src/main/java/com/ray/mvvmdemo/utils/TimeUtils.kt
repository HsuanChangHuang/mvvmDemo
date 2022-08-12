package com.ray.mvvmdemo.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object TimeUtils {
    fun getTimeFormat(time: String): String{
        val inputFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssXXX")
        val datetime: OffsetDateTime = OffsetDateTime.parse(time, inputFormatter)
        val date = Date.from(datetime.toInstant())
        return formatDateTime(date)
    }

    private fun formatDateTime(date: Date): String {
        val DATE_FORMAT =
            SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        val TIME_ZONE = TimeZone.getTimeZone("Asia/Taipei")
        DATE_FORMAT.timeZone = TIME_ZONE
        return DATE_FORMAT.format(date)
    }
}