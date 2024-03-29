package by.danilko.spring;

import by.danilko.spring.config.ApplicationConfiguration;
import by.danilko.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
//       var context = new ClassPathXmlApplicationContext("application.xml");
       var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

       var companyService = context.getBean(CompanyService.class);
//       var userRepository = context.getBean(UserRepository.class);
        companyService.findById(1);
        context.close();

    }
}
