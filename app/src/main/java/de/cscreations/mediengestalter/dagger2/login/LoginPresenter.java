package de.cscreations.mediengestalter.dagger2.login;

import android.support.annotation.Nullable;

public class LoginPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstname());
                view.setLastName(user.getLastname());
            }
        }
    }
}
