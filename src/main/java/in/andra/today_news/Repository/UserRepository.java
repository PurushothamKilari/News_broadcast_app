
package in.andra.today_news.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.andra.today_news.EntityClasses.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here, e.g.:
    User findByUsername(String username);
    User findByEmail(String email);
}
