package test.resource.com.br.bankapp.di.component

import dagger.Component
import test.resource.com.br.bankapp.BaseApp
import test.resource.com.br.bankapp.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}