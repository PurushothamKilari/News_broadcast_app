package in.andra.today_news.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.andra.today_news.EntityClasses.User;

// @Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
