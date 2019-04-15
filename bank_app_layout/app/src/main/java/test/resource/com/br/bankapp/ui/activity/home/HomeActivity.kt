package test.resource.com.br.bankapp.ui.activity.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.di.component.DaggerHomeComponent
import test.resource.com.br.bankapp.di.module.HomeModule
import test.resource.com.br.bankapp.model.Statement
import test.resource.com.br.bankapp.model.UserAccount
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.HomeViewInterface {

    @Inject
    lateinit var presenter: HomeContract.HomePresenterInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val user = getUserAccount()
        user?.let { fillFields(it) }
    }

    private fun injectDependency() {
        val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(this))
                .build()
        homeComponent.inject(this)
        presenter.attach(this)
    }

    private fun getUserAccount(): UserAccount? {
        return intent.extras?.getParcelable<UserAccount>("user")
    }

    private fun fillFields(user: UserAccount) {
        home_txt_name.text = user.name
        home_txt_title_account.text = user.bankAccount + "/" + user.agency
        home_txt_balance.text = user.balance.toString()
    }

    override fun showToast(s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayStatement(statement: List<Statement>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}