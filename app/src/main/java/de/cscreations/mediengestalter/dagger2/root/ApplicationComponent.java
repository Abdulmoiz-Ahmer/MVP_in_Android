package de.cscreations.mediengestalter.dagger2.root;

import javax.inject.Singleton;

import dagger.Component;
import de.cscreations.mediengestalter.dagger2.login.LoginActivity;
import de.cscreations.mediengestalter.dagger2.login.LoginModule;

@Singleton
@Component(modules = {ApplicationModule.class,LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity targetForInjection);
}
