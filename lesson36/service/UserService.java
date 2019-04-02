package lesson36.service;

import lesson36.model.Session;
import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {
        //check business logic

        //if logic is ok
        return userRepository.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userRepository.login(userName, password);
    }

    public void logout() {
        userRepository.logout();
    }
}
