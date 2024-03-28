package by.danilko.spring.database.repository;

import by.danilko.spring.bpp.InjectBean;
import by.danilko.spring.database.repository.pool.ConnectionPool;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ToString
public class UserRepository {
    private final ConnectionPool connectionPool;
    private final Integer poolSize;
    private final List<ConnectionPool> connectionPools;

    public UserRepository(ConnectionPool connectionPool,
                          @Value("${db.pool.size}") Integer poolSize,
                          List<ConnectionPool> connectionPools) {
        this.connectionPool = connectionPool;
        this.poolSize = poolSize;
        this.connectionPools = connectionPools;
    }
}
