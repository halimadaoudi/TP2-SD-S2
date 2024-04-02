package fs.miaad.application.Repositories;
import fs.miaad.application.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}


