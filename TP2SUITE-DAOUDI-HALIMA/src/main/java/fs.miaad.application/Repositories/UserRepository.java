package fs.miaad.application.Repositories;
import fs.miaad.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
