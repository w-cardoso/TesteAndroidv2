package test.resource.com.br.bankapp.di.component

import dagger.Component
import test.resource.com.br.bankapp.di.module.LoginModule
import test.resource.com.br.bankapp.ui.activity.login.LoginActivity

@Component(modules = arrayOf(LoginModule::class))
interface ActivityComponent {

    fun inject(loginActivity: LoginActivity)

}