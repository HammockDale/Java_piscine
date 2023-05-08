package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = (UsersRepository)context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll());
        System.out.println(usersRepository.findById(2L));
        System.out.println(usersRepository.findByEmail("aba@yandex.ru"));

        try {
            User userAdd = new User(15L, "ckl@yandex.ru");
            usersRepository.save(userAdd);
            System.out.println(usersRepository.findAll());
        } catch (DuplicateKeyException var6) {
            System.err.println("DuplicateKeyException");
        }

        usersRepository.delete(15L);
        usersRepository.delete(20L);
        System.out.println(".............................................");
        UsersRepository usersRepository2 = (UsersRepository)context.getBean("usersRepositoryJdbc", UsersRepository.class);
        System.out.println(usersRepository2.findAll());
        System.out.println(usersRepository2.findById(2L));
        System.out.println(usersRepository2.findByEmail("aba@yandex.ru"));

        try {
            User userAdd = new User(15L, "ckl@yandex.ru");
            usersRepository2.save(userAdd);
            System.out.println(usersRepository2.findAll());
        } catch (DuplicateKeyException var5) {
            System.err.println("DuplicateKeyException");
        }

        usersRepository2.delete(15L);
        usersRepository2.delete(25L);
    }
}