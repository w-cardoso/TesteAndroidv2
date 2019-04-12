package test.resource.com.br.bankapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ListStatementResponse(@SerializedName("statementList")
                            @Expose
                            val statementList: List<Statement>,

                            @SerializedName("error")
                            @Expose
                            val error: ErrorResponse)