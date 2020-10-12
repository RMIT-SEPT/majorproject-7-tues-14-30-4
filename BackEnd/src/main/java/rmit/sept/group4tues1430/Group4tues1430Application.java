package rmit.sept.group4tues1430;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Group4tues1430Application {

    public static void main(String[] args) {
        SpringApplication.run(Group4tues1430Application.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder(); }
}
