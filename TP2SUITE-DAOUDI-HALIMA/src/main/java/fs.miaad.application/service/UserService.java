package fs.miaad.application.service;
import fs.miaad.application.entities.Role;
import fs.miaad.application.entities.User;
public interface UserService {

    User  addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);

    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username , String roleName);
    User authenticate(String username , String password);
}
