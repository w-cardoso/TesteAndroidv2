package test.resource.com.br.bankapp.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import test.resource.com.br.bankapp.BaseApp
import test.resource.com.br.bankapp.di.scope.PerApplication
import javax.inject.Singleton


@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}