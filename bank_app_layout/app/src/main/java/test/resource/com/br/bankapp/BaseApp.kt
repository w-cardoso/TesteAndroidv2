package test.resource.com.br.bankapp

import android.app.Application
import test.resource.com.br.bankapp.di.component.ApplicationComponent
import test.resource.com.br.bankapp.di.component.DaggerApplicationComponent
import test.resource.com.br.bankapp.di.module.ApplicationModule

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}