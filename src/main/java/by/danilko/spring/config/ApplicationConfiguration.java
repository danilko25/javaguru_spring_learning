package by.danilko.spring.config;

import by.danilko.spring.database.repository.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration

public class ApplicationConfiguration {

    @Bean("connectionPool1")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool connectionPool(@Value("${db.username}")String username){
        return new ConnectionPool(username, "root", 20, "url");
    }

    @Bean
    public ConnectionPool connectionPool2(){
        return new ConnectionPool("mysql", "123", 100, "---");
    }
}
