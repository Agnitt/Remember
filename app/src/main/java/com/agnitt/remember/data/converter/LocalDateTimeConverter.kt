package com.agnitt.remember.data.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime


class LocalDateTimeConverter {
    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? = dateString?.let(LocalDateTime::parse)

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? = date?.toString()
}
