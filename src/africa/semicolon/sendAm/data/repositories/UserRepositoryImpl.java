package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;


import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private List<User> userList = new ArrayList<User>();

    @Override
    public User save(User newUser) {
        String email = newUser.getEmail();
        newUser.setEmail(email);
        userList.add(newUser);

        return newUser ;
    }

    @Override
    public User findByEmail(String email) {
        for (User aUser : userList){
            if (aUser.getEmail().equals(email)) return aUser;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
    }

    @Override
    public void delete(String email) {
        User newUser = findByEmail(email);
        delete(newUser);
    }

    @Override
    public int count() {
        return userList.size();
    }
}
