package com.example.mynews.modelclasses

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("title"           ) var title          : String?           = null,
  @SerializedName("link"            ) var link           : String?           = null,
  @SerializedName("description"     ) var description    : String?           = null,
  @SerializedName("content"         ) var content        : String?           = null,
  @SerializedName("pubDate"         ) var pubDate        : String?           = null,
  @SerializedName("image_url"       ) var imageUrl       : String?           = null,

)