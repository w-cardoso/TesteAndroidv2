package test.resource.com.br.bankapp.ui.activity.home

import test.resource.com.br.bankapp.model.Statement

interface HomeContract {

    interface HomeViewInterface {
        fun showToast(s: String)
        fun displayStatement(statement: List<Statement>)
        fun displayError(s: String)
    }

    interface HomePresenterInterface {
        fun getStatementList(id: Int)
    }
}