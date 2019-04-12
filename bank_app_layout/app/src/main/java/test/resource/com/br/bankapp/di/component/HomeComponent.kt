package test.resource.com.br.bankapp.di.component

import dagger.Component
import test.resource.com.br.bankapp.di.module.HomeModule
import test.resource.com.br.bankapp.ui.activity.home.HomeActivity

@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)

}