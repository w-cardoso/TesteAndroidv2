package test.resource.com.br.bankapp.ui.activity.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.di.component.DaggerActivityComponent
import test.resource.com.br.bankapp.di.module.LoginModule
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.UserAccount
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    @Inject lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        injectDependency()
        presenter.attach(this)
        verifyFieldUser()
        verifyFieldPassword()

        val login = Login(login_edt_user.text.toString(), login_edt_password.toString())
        presenter.validateUser(login)
    }

    private fun verifyFieldPassword() {
        presenter.validateFieldPassword(login_edt_password, applicationContext)
    }

    private fun verifyFieldUser() {
        presenter.validateFieldUser(login_edt_user, applicationContext)
    }


    override fun showToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(user: UserAccount) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .loginModule(LoginModule(this))
                .build()

        activityComponent.inject(this)
    }
}
