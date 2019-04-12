package test.resource.com.br.bankapp.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import test.resource.com.br.bankapp.ui.activity.login.LoginContract
import test.resource.com.br.bankapp.ui.activity.login.LoginPresenter

@Module
class LoginModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): LoginContract.LoginPresenter {
        return LoginPresenter()
    }
}