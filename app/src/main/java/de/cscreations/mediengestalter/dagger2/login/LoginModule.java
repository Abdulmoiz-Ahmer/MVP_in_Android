package de.cscreations.mediengestalter.dagger2.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(loginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    public loginRepository provideLoginRepository(){
        return new MemoryRepository();
    }


}
