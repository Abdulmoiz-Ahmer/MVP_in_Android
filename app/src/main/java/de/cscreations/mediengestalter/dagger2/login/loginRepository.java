package de.cscreations.mediengestalter.dagger2.login;

public interface loginRepository {
    public User getUser();
    public void saveUser(User user);
}
