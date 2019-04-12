package test.resource.com.br.bankapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Statement(@SerializedName("title")
                @Expose
                val title: String,

                @SerializedName("desc")
                @Expose
                val description: String,

                @SerializedName("date")
                @Expose
                val date: String,

                @SerializedName("value")
                @Expose
                val value: Double)