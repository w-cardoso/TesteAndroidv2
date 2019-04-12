package test.resource.com.br.bankapp.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.di.component.DaggerActivityComponent
import test.resource.com.br.bankapp.di.module.LoginModule
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.UserAccount
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), LoginContract.LoginView {


    @Inject
    lateinit var presenter: LoginContract.LoginPresenter

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
        Toast.makeText(this, message, Toast.LENGTH_LONG)
    }

    override fun getUser(user: UserAccount) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)    }

    override fun showProgress(show: Boolean) {
        if (show) {
            login_pgb.visibility = View.VISIBLE
            login_btn.visibility = View.GONE
        } else {
            login_pgb.visibility = View.GONE
            login_btn.visibility = View.VISIBLE
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .loginModule(LoginModule(this))
                .build()

        activityComponent.inject(this)
    }
}
