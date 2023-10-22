package com.manuelapk.pelis.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedResult<T>(
    val page: Int,
    val results: List<T>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)
