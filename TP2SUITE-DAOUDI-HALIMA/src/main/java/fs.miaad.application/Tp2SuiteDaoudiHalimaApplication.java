package fs.miaad.application;
import fs.miaad.application.entities.Role;
import fs.miaad.application.entities.User;
import fs.miaad.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;
@SpringBootApplication
public class Tp2SuiteDaoudiHalimaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Tp2SuiteDaoudiHalimaApplication.class, args);
    }

    @Autowired
    private UserService userService ;
    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setUsername("halima");
        u.setPassword("123456");
        userService.addNewUser(u);

        User u2 = new User();
        u2.setUsername("admin");
        u2.setPassword("123456");
        userService.addNewUser(u2);

        Stream.of("STUDENT" , "USER" , "ADMIN").forEach(r->{
            Role role1 = new Role();
            role1.setRoleName(r);
            userService.addNewRole(role1);
        });

        userService.addRoleToUser("halima" ,"STUDENT");
        userService.addRoleToUser("halima" ,"USER");
        userService.addRoleToUser("admin" ,"ADMIN");
        userService.addRoleToUser("admin" ,"USER");

        try {
            User user = userService.authenticate("halima","123456" );
            System.out.println(user.getUserId());
            System.out.println(user.getUsername());
            user.getRoles().forEach(r ->{
                System.out.println("Role => " +r.toString());
            });
        }catch (Exception exception){
              exception.printStackTrace();
        }
    }
}
