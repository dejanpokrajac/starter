package com.sample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Repo(
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("open_issues")
    val openIssues: Int?
)