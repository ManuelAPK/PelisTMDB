package com.manuelapk.pelis.data.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manuelapk.pelis.data.model.TimeWindow

class Converter {

    @TypeConverter
    fun stringToTimeWindow(data: String?) = data?.let { TimeWindow.valueOf(it) }
    @TypeConverter
    fun timeWindowToString(timeWindow: TimeWindow) = timeWindow.name

    @TypeConverter
    fun stringToLongList(data: String?): List<Long?>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Long?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun longListToString(someObjects: List<Long?>?): String? {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun stringToStringList(data: String?): List<String?>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun stringListToString(someObjects: List<String?>?): String? {
        return Gson().toJson(someObjects)
    }
}