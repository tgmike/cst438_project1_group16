package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import userClass.User;

public class userDAO implements DAO<User> {
    private List<User> users = new ArrayList<>();

    public void UserDao(){
        users.add(new User("Default User", "DefaultPass1"));
    }

    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        user.setPassword(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        users.add(user);
    }

    public void delete(User user) {
        users.remove(user);
    }
}