package kraemer.spring_data_jpa;

import kraemer.spring_data_jpa.model.User;
import kraemer.spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> usuariosPorNomeQueryOverride = userRepository.filtrarPorNome("Gustavo");
        System.out.println("Query Override: " + usuariosPorNomeQueryOverride);

        List<User> usuariosPorNomeContain = userRepository.findUserByNameContaining("tavo");
        System.out.println("Query method contain: " + usuariosPorNomeContain);

        List<User> usuariosPorNome = userRepository.findUserByName("Kraemer");
        System.out.println("Query method: " + usuariosPorNome);
    }

    private void insertUser() {
        User user = new User();
        user.setName("teste");
        user.setUsername("test");
        user.setPassword("123");

        userRepository.save(user);

        for(User u: userRepository.findAll()) {
            System.out.println(u);
        }
    }
}
