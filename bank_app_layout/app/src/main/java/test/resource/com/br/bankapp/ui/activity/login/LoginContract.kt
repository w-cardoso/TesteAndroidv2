package test.resource.com.br.bankapp.ui.activity.login

import android.text.Editable
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.UserAccount

interface LoginContract {

    interface LoginView {
        fun showToast(message: String)

        fun getUser(user: UserAccount)
    }

    interface LoginPresenter {
        fun validateFileldUser(text: String)

        fun validateFieldPassword()

        fun saveUser()

        fun validateUser(login: Login)


    }
}