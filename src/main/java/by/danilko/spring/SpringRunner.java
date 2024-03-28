package by.danilko.spring;

import by.danilko.spring.config.ApplicationConfiguration;
import by.danilko.spring.database.repository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
//       var context = new ClassPathXmlApplicationContext("application.xml");
       var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
       var userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository);
        context.close();

    }
}
