package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUserIfNotExist(context.getBean("userBean", User.class));
        userService.addUserIfNotExist(context.getBean("userBean", User.class));
        userService.add(new User("Nick", "Lost", "qwer@gmail.com"));
        userService.add(new User("Алекс", "Prey", "APrey@gmail.com"));

        System.out.println(userService.listUsers().toString());

//        userService.dropUsersTable();


        context.close();
    }
}
