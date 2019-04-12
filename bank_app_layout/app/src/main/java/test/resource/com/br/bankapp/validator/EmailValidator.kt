package test.resource.com.br.bankapp.validator

import android.content.Context
import android.widget.EditText


class EmailValidator(private val fieldEmail: EditText, private val context: Context) : Validator {
    private val standardValidator: StandardValidator = StandardValidator(this.fieldEmail, context)

    private fun standardValidate(email: String): Boolean {
        if (email.matches(".+@.+\\..+".toRegex())) {
            return true
        }
        fieldEmail.error = "Digite um email válido"
        return false
    }


    override fun isValid(): Boolean {
        // if (!standardValidator.isValid()) return false;
        val email = fieldEmail.text.toString()
        return standardValidate(email)
    }
}