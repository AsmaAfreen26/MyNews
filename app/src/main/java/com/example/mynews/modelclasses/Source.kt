package com.example.mynews.modelclasses

import com.google.gson.annotations.SerializedName


data class Source (

  @SerializedName("status"       ) var status       : String?            = null,
  @SerializedName("totalResults" ) var totalResults : Int?               = null,
  @SerializedName("results"      ) var results      : ArrayList<Results> = arrayListOf(),
  @SerializedName("nextPage"     ) var nextPage     : String?            = null

)