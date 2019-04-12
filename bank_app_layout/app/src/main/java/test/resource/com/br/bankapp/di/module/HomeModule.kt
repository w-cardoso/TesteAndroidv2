package test.resource.com.br.bankapp.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import test.resource.com.br.bankapp.ui.activity.home.HomeContract
import test.resource.com.br.bankapp.ui.activity.home.HomePresenter
import test.resource.com.br.bankapp.ui.activity.login.LoginContract
import test.resource.com.br.bankapp.ui.activity.login.LoginPresenter

@Module
class HomeModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): HomeContract.HomePresenterInterface {
        return HomePresenter()
    }
}