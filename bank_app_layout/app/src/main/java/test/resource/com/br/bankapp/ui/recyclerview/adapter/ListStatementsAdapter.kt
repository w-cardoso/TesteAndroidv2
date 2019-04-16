package test.resource.com.br.bankapp.ui.recyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import kotlinx.android.synthetic.main.item_card_payment.view.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.model.Statement

class ListStatementsAdapter(private val listStatement: List<Statement>,
                            private val context: Context) : RecyclerView.Adapter<ListStatementsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_payment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStatement.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statement = listStatement[position]


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.item_payment_title
        val description = itemView.item_payment_description
        val date = itemView.item_payment_date
        val value = itemView.item_payment_value
    }

}