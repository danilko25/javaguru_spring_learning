package by.danilko.spring.database.repository.pool;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ConnectionPool {
    private String username;
    private String password;
    private int poolSize;
    private String url;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.password}") String password,
                          @Value("${db.pool.size}") int poolSize,
                          @Value("${db.url}") String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }
}
