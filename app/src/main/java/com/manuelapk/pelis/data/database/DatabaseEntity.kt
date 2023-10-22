package com.manuelapk.pelis.data.database

interface DatabaseEntity <T>{
    fun toDatabase():T
}