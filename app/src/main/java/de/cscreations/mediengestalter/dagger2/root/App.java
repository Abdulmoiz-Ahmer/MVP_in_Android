package de.cscreations.mediengestalter.dagger2.root;

import android.app.Application;

import de.cscreations.mediengestalter.dagger2.login.LoginModule;

public class App extends Application {
    public ApplicationComponent getComponent() {
        return component;
    }

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }
}
