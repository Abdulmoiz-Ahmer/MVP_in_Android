package de.cscreations.mediengestalter.dagger2.login;

public class LoginModel implements LoginActivityMVP.Model {
    public LoginModel(loginRepository repository) {
        this.repository = repository;
    }

    private loginRepository repository;

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname,lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
