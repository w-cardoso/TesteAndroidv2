package test.resource.com.br.bankapp.model

class Login {
    private var user: String
    private var password: String

    constructor(user: String, password: String) {
        this.user = user
        this.password = password
    }
}