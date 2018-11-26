package de.cscreations.mediengestalter.dagger2.login;

public interface LoginActivityMVP {
    interface View {
        String getFirstName();
        String getLastName();
        void setFirstName(String firstname);
        void setLastName(String lastname);
        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();
    }

    interface Presenter {
        void setView(LoginActivityMVP.View view);
        void loginClicked();
        void getCurrentUser();
    }

    interface Model {
        void createUser(String fname,String lname);
        User getUser();
    }
}
