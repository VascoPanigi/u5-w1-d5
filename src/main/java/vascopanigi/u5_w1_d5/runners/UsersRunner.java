package vascopanigi.u5_w1_d5.runners;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import vascopanigi.u5_w1_d5.entities.User;
import vascopanigi.u5_w1_d5.repositories.UserRepository;

import java.util.Arrays;
import java.util.Locale;


//@Component
@Order(2)
public class UsersRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{

        Faker faker = new Faker(Locale.ITALY);

        User user1 = new User(faker.internet().emailAddress(), faker.name().fullName(), faker.gameOfThrones().character());
        User user2 = new User(faker.internet().emailAddress(), faker.name().fullName(), faker.gameOfThrones().character());
        User user3 = new User(faker.internet().emailAddress(), faker.name().fullName(), faker.gameOfThrones().character());
        User user4 = new User(faker.internet().emailAddress(), faker.name().fullName(), faker.gameOfThrones().character());

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
    }
}
