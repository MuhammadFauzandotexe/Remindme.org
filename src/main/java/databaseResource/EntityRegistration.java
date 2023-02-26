package databaseResource;
import javax.persistence.*;
@Entity
@Table(name = "user_registration")
public class EntityRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "email_registration",length = 50,unique = false,nullable = true)
    public String email;
    @Column(name = "name_registration",length = 50,nullable = true)
    public String name;
    @Column(name = "password_registration",unique = false,nullable = true)
    public String password;
    @Column(name = "token",unique = false,nullable = true)
    public String key_value;
    @Column(name = "bash64_decode",nullable = true)
    public String bash64_decode;
}
