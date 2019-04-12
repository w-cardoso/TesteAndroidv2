package test.resource.com.br.bankapp.ui.activity.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.di.component.DaggerHomeComponent
import test.resource.com.br.bankapp.di.module.HomeModule
import test.resource.com.br.bankapp.model.Statement
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.HomeViewInterface {

    @Inject
    lateinit var presenter: HomeContract.HomePresenterInterface


    override fun showToast(s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayStatement(statement: List<Statement>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    private fun injectDependency() {
        val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(this))
                .build()
        homeComponent.inject(this)
        presenter.attach(this)
    }
}