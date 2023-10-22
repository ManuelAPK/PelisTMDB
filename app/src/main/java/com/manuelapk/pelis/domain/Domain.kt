package com.manuelapk.pelis.domain

interface Domain<T> {
    fun toDomain():T
}