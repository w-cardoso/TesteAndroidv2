package test.resource.com.br.bankapp.ui.activity.home

import com.ogulcan.android.mvp.app.ui.base.BaseContract
import test.resource.com.br.bankapp.model.Statement

interface HomeContract {

    interface HomeViewInterface : BaseContract.View {
        fun showToast(s: String)
        fun displayStatement(statement: List<Statement>)
    }

    interface HomePresenterInterface : BaseContract.Presenter<HomeContract.HomeViewInterface> {
        fun getStatementList(id: Int)
    }
}