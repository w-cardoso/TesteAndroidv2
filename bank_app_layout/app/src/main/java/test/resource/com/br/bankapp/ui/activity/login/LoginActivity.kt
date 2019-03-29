package test.resource.com.br.bankapp.ui.activity.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import test.resource.com.br.bankapp.R
import test.resource.com.br.bankapp.model.UserAccount

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.validateFileldUser(login_edt_user.text.toString())
    }


    override fun showToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(user: UserAccount) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
