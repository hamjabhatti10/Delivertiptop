package com.hamza.delivertiptop.models

import com.google.gson.annotations.SerializedName

class ErrorResponce(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    val code: Int
)