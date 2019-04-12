package test.resource.com.br.bankapp.ui.activity.home

class HomePresenter : HomeContract.HomePresenterInterface {

    private lateinit var view: HomeContract.HomeViewInterface


    override fun attach(view: HomeContract.HomeViewInterface) {
        this.view = view

    }


    override fun getStatementList(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}