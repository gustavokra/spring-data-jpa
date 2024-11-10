package kraemer.spring_data_jpa.repository;

import kraemer.spring_data_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    public List<User> filtrarPorNome(@Param("name") String name);

    public List<User> findUserByName(String name);

    public List<User> findUserByNameContaining(String name);

}
