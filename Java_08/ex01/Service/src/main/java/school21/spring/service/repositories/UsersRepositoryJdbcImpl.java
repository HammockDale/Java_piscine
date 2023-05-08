//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package school21.spring.service.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import school21.spring.service.models.User;

public class UsersRepositoryJdbcImpl implements UsersRepository<User> {
    private static Connection connection;
    private static PreparedStatement myPreparestatement;

    public UsersRepositoryJdbcImpl(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        this.createTable();
    }

    private void createTable() throws SQLException {
        try {
            String SQL = "CREATE TABLE IF NOT EXISTS users (identifier BIGINT PRIMARY KEY, email VARCHAR(50) NOT NULL UNIQUE);";
            myPreparestatement = connection.prepareStatement(SQL);
            User user01 = new User(1L, "asd@yandex.ru");
            User user02 = new User(2L, "bf@yandex.ru");
            User user03 = new User(3L, "cc@yandex.ru");
            if (this.findById(user01.getIdentifier()) == null) {
                this.save(user01);
            }

            if (this.findById(user02.getIdentifier()) == null) {
                this.save(user02);
            }

            if (this.findById(user03.getIdentifier()) == null) {
                this.save(user03);
            }

            myPreparestatement.executeUpdate();
        } catch (SQLException var5) {
        }

    }

    public User findById(Long id) {
        User people = null;

        try {
            myPreparestatement = connection.prepareStatement("SELECT * FROM users WHERE identifier=?");
            myPreparestatement.setLong(1, id);
            ResultSet resultSet = myPreparestatement.executeQuery();
            resultSet.next();
            people = new User();
            people.setIdentifier(resultSet.getLong("identifier"));
            people.setEmail(resultSet.getString("email"));
            return people;
        } catch (SQLException var4) {
            return people;
        }
    }

    public List<User> findAll() {
        List<User> people = null;

        try {
            String SQL = "SELECT * FROM users";
            myPreparestatement = connection.prepareStatement(SQL);
            ResultSet resultSet = myPreparestatement.executeQuery();
            people = new ArrayList();

            while(resultSet.next()) {
                User person = new User();
                person.setIdentifier(resultSet.getLong("identifier"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException var5) {
            System.err.println("Table not found");
        }

        return people;
    }

    public void save(User entity) {
        try {
            String SQL = "INSERT INTO users VALUES(?, ?)";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setLong(1, entity.getIdentifier());
            myPreparestatement.setString(2, entity.getEmail());
            myPreparestatement.executeUpdate();
        } catch (SQLException var3) {
            System.err.println("User id [" + entity.getIdentifier() + "] already exist");
        }

    }

    public void update(User entity) {
        try {
            String SQL = "UPDATE users SET email=? WHERE identifier=?";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setString(1, entity.getEmail());
            myPreparestatement.setLong(2, entity.getIdentifier());
            myPreparestatement.executeUpdate();
        } catch (SQLException var3) {
        }

    }

    public void delete(Long id) {
        try {
            String SQL = "DELETE FROM users WHERE identifier=?";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setLong(1, id);
            myPreparestatement.executeUpdate();
        } catch (SQLException var3) {
        }

    }

    public Optional<User> findByEmail(String email) {
        User people;
        try {
            myPreparestatement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            myPreparestatement.setString(1, email);
            ResultSet resultSet = myPreparestatement.executeQuery();
            resultSet.next();
            people = new User();
            people.setIdentifier((long)resultSet.getLong("identifier"));
            people.setEmail(resultSet.getString("email"));
        } catch (SQLException var4) {
            return Optional.empty();
        }

        Optional<User> userOptional = Optional.of(people);
        return userOptional;
    }

    private void close() throws SQLException {
        connection.close();
    }
}
