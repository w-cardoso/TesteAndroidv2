package test.resource.com.br.bankapp.ui.activity.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.di.component.DaggerLoginComponent
import test.resource.com.br.bankapp.di.module.LoginModule
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.UserAccount
import test.resource.com.br.bankapp.ui.activity.home.HomeActivity
import test.resource.com.br.bankapp.util.SecurePreferences
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), LoginContract.LoginView {


    @Inject
    lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        injectDependency()
        verifyFieldUser()
        verifyFieldPassword()
        initializeSharedPreferences()
        clickForLogin()

    }

    private fun clickForLogin() {
        login_btn.setOnClickListener {
            if (presenter.validAllFields()) {
                presenter.saveUser(this, login_edt_user.text.toString(), login_edt_password.text.toString())
                val login = Login(login_edt_user.text.toString(), login_edt_password.toString())
                presenter.validateUser(login)
            }
        }
    }

    private fun initializeSharedPreferences() {
        val preferences = SecurePreferences(this, "user-info",
                "userInformation", true)
        val username = preferences.getString("username")
        val password = preferences.getString("password")
        verifyPreferences(username, password)

    }

    private fun verifyPreferences(username: String?, password: String?) {
        if (username != null || password != null) {
            login_edt_user.setText(username)
            login_edt_password.setText(password)
        }
    }

    private fun verifyFieldPassword() {
        presenter.validateFieldPassword(login_edt_password, applicationContext)
    }

    private fun verifyFieldUser() {
        presenter.validateFieldUser(login_edt_user, applicationContext)
    }


    override fun showToast(message: String) {
        showProgress(false)
        Toast.makeText(this, message, Toast.LENGTH_LONG)
    }

    override fun getUser(user: UserAccount) {
        showProgress(false)
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

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
        val activityComponent = DaggerLoginComponent.builder()
                .loginModule(LoginModule(this))
                .build()
        activityComponent.inject(this)
        presenter.attach(this)
    }
}
