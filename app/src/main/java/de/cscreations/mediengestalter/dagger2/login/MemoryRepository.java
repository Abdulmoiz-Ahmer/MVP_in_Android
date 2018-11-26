package de.cscreations.mediengestalter.dagger2.login;

public class MemoryRepository implements loginRepository {
    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            user = new User("Ace", "Ventura");
            user.setId(0);
            return user;
        } else return user;

    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user=getUser();
        }
        this.user = user;
    }
}
