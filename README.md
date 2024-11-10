# Spring Data JPA
Adiciona uma camada sobre o JPA.

A interaçao com banco de dados será através de herança e interfaces.


## Interfaces
- CrudRepository
- JPARepository
- PagingAndSortingRepository

## Anotações
@Query

@Param


## Criando repositórios

```
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

```
public interface UserRepository extends JpaRepository<User, Integer> {

}
```

```
@Component  
public class StartApp implements CommandLineRunner {  
  
    @Autowired  
    private UserRepository userRepository;  
  
    @Override  
    public void run(String... args) throws Exception {  
        User user = new User();  
        user.setName("Gustavo");  
        user.setUsername("gkramer");  
        user.setPassword("123");  
  
        userRepository.save(user);  
  
        for(User u: userRepository.findAll()) {  
            System.out.println(u);  
        }  
    }  
}
```
