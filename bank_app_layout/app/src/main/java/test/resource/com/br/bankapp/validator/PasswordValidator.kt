package test.resource.com.br.bankapp.validator

import android.content.Context
import android.widget.EditText


class PasswordValidator(private val fieldPassword: EditText, private val context: Context) : Validator {
    private val standardValidator: StandardValidator = StandardValidator(fieldPassword, context)

    private fun standardValidate(password: String): Boolean {
        if (password.matches("((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,16})".toRegex())) {
            return true
        }
        fieldPassword.error = "Sua senha não possui os requisitos minimos"
        return false

    }


    override fun isValid(): Boolean {
        // if (!standardValidator.isValid()) return false;
        val password = fieldPassword.text.toString()
        return standardValidate(password)
    }
}