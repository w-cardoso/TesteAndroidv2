package test.resource.com.br.bankapp.validator

import android.content.Context
import android.widget.EditText


class StandardValidator(private val field: EditText, private val context: Context) : Validator {

    override fun isValid(): Boolean {
        if (!validateFieldRequired()) return false
        removeError()
        return false
    }

    private fun validateFieldRequired(): Boolean {
        val text = field.text.toString()
        if (text.isEmpty()) {
            field.error = "Campo esta vazio"
            return false
        }
        return true

    }

    private fun removeError() {
        field.error = null
    }
}