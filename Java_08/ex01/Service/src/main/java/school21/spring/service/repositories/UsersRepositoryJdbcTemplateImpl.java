//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package school21.spring.service.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository<User> {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userRowMapper = (resultSet, index) -> {
        return new User(resultSet.getLong("identifier"), resultSet.getString("email"));
    };

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.createTable();
    }

    private void createTable() {
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (identifier BIGINT PRIMARY KEY , email VARCHAR(50) NOT NULL UNIQUE);");
        User user01 = new User(1L, "aaa@yandex.ru");
        User user02 = new User(2L, "bbb@yandex.ru");
        User user03 = new User(3L, "ccc@yandex.ru");
        if (this.findById(user01.getIdentifier()) == null) {
            this.save(user01);
        }

        if (this.findById(user02.getIdentifier()) == null) {
            this.save(user02);
        }

        if (this.findById(user03.getIdentifier()) == null) {
            this.save(user03);
        }

    }

    @Deprecated
    public void save(User entity) {
        if (this.findById(entity.getIdentifier()) != null) {
            System.err.println("User id [" + entity.getIdentifier() + "] already exist");
        } else {
            this.jdbcTemplate.update("INSERT INTO users VALUES(?, ?)", new Object[]{entity.getIdentifier(), entity.getEmail()});
        }
    }

    @Deprecated
    public void update(User entity) {
        this.jdbcTemplate.update("UPDATE users SET email=? WHERE identifier=?", new Object[]{entity.getEmail(), entity.getIdentifier()});
    }

    @Deprecated
    public void delete(Long id) {
        if (this.jdbcTemplate.update("DELETE FROM users WHERE identifier=?", new Object[]{id}) == 0) {
            ;
        }
    }

    @Deprecated
    public List<User> findAll() throws DataAccessException {
        return this.jdbcTemplate.query("SELECT * FROM users", this.userRowMapper);
    }


//    @Deprecated
//    public User findById(Long id) {
//        return (User)this.jdbcTemplate.query("SELECT * FROM users WHERE identifier=?", new Object[]{id}, this.userRowMapper).stream().findAny().orElse((User) null);
//    }


    @Override
    @Deprecated
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE identifier=?", new Object[]{id}, userRowMapper).stream().findAny().orElse(null);
    }

    @Deprecated
    public Optional<User> findByEmail(String email) {
        Optional<User> userO = this.jdbcTemplate.query("SELECT * FROM users  WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper(User.class)).stream().findAny();
        return userO;
    }

    @Deprecated
    private void close() throws SQLException {
        Connection data = this.jdbcTemplate.getDataSource().getConnection();
        data.close();
    }
}
