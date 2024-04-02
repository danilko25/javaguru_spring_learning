package by.danilko.annotation;

import by.danilko.integration.TestApplicationRunner;
import by.danilko.spring.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//Профайл для використання test properties
@ActiveProfiles("test")
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@Transactional
public @interface IT {
}
