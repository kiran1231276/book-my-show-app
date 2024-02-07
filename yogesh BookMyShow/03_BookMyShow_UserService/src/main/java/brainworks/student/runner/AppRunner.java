package brainworks.student.runner;



import brainworks.student.entity.User;
import brainworks.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1=new User ();
        user1.setEmail ("yogesh@gmail.com");
        user1.setDob (LocalDate.parse ("1992-04-22"));
        user1.setUserId (UUID.randomUUID ().toString ());
        user1.setUsername ("yogesh@123");
        user1.setFullname ("Yogesh Sanap");
        user1.setPassword (passwordEncoder.encode ("Yogesh@123"));

        User user2=new User ();
        user2.setEmail ("manish@gmail.com");
        user2.setDob (LocalDate.parse ("1996-04-22"));
        user2.setUserId (UUID.randomUUID ().toString ());
        user2.setUsername ("manish@123");
        user2.setFullname ("Manish Gupta");
        user2.setPassword (passwordEncoder.encode ("Manish@123"));

        User user3=new User ();
        user3.setEmail ("ajay@gmail.com");
        user3.setDob (LocalDate.parse ("1994-04-22"));
        user3.setUserId (UUID.randomUUID ().toString ());
        user3.setUsername ("ajay@123");
        user3.setFullname ("Ajay Verma");
        user3.setPassword (passwordEncoder.encode ("Ajay@123"));

//        userRepository.save (user1);
//        userRepository.save (user2);
//        userRepository.save (user3);

    }
}
