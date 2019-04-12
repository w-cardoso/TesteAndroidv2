package test.resource.com.br.bankapp.ui.activity.login

import android.content.Context
import android.text.Editable
import android.widget.EditText
import com.ogulcan.android.mvp.app.ui.base.BaseContract
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.UserAccount

interface LoginContract {

    interface LoginView : BaseContract.View {
        fun showToast(message: String)
        fun getUser(user: UserAccount)
    }

    interface LoginPresenter : BaseContract.Presenter<LoginContract.LoginView> {
        fun validateFieldUser(
                edtUser: EditText,
                context: Context
        )

        fun validateFieldPassword(
                edtUser: EditText,
                context: Context
        )

        fun saveUser()

        fun validateUser(login: Login)

        fun validAllFields(): Boolean
    }
}