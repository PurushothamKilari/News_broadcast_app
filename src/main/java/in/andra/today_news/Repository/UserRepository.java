
package in.andra.today_news.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.andra.today_news.EntityClasses.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here, e.g.:
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // Custom query to check if username and password match (alternative to service-level auth)
    @Query("SELECT u FROM User u WHERE u.email = :username AND u.password = :password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // Check if a user with a given email exists (for reset password)
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
