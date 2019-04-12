package test.resource.com.br.bankapp.ui.activity.login

import android.content.Context
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.LoginResponse
import test.resource.com.br.bankapp.service.ApiServiceInterface
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
        edtPassword.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validator.isValid()
            }
        }
    }

    override fun saveUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validateUser(login: Login) {
        val loginResponse = ApiServiceInterface.create().login(login)

        loginResponse.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                response.body()?.userAccount?.let { view.getUser(it) }
                response.body()?.errorResponse?.let { view.showToast(it.message) }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.showToast("Não foi possivel validar o usuário")
            }
        })
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

