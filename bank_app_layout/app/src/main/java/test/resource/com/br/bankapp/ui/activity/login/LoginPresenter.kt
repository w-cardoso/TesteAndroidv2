package test.resource.com.br.bankapp.ui.activity.login

import android.content.Context
import android.text.Editable
import android.view.View
import test.resource.com.br.bankapp.model.Login
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import test.resource.com.br.bankapp.validator.EmailValidator
import test.resource.com.br.bankapp.validator.PasswordValidator
import test.resource.com.br.bankapp.validator.Validator


class LoginPresenter : LoginContract.LoginPresenter {

    private lateinit var view: LoginContract.LoginView
    private val validators = ArrayList<Validator>()


    override fun validateFieldUser(edtUser: EditText, context: Context) {
        val validator = EmailValidator(edtUser, context)
        validators.add(validator)
        edtUser.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validator.isValid()
            }
        }
    }

    override fun validateFieldPassword(edtPassword: EditText, context: Context) {
        val validator = PasswordValidator(edtPassword, context)
        validators.add(validator)
        edtPassword.onFocusChangeListener = OnFocusChangeListener{ v, hasFocus ->
            if (!hasFocus){
                validator.isValid()
            }
        }
    }

    override fun saveUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validateUser(login: Login) {

    }


    override fun attach(view: LoginContract.LoginView) {
        this.view = view

    }

    override fun validAllFields(): Boolean {
        var formIsValid = true
        for (validator in validators) {
            if (!validator.isValid()) {
                formIsValid = false
            }
        }
        return formIsValid
    }
}

