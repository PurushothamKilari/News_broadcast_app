package in.andra.today_news.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.andra.today_news.EntityClasses.User;
import in.andra.today_news.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("A user with this email already exists.");
        }
        user.setRole("USER");
        user.setCreatedAt(java.time.LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username,password);
        return user.isPresent() && user.get().getPassword().equals(password);
    }


    @Override
    public boolean resetPassword(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            // Simulate sending reset email or changing the password
            System.out.println("Reset link sent to: " + email);
            return true;
        }
        return false;
    }

    @Override
    public User createUser(User user) {
        // user.setCreatedAt(LocalDateTime.now());
        // user.setEmail("madhusudhan");
        // user.setPassword("confidential");
        // user.setRole("admin");
        // user.setUsername("madhu");

        // System.out.println(user.toString());
        // return user;

        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
