package databaseResource;

import javax.persistence.*;

@Entity()
@Table(name = "user_registered")
public class UserRegistered {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "email")
    String email;
    @Column(name = "username")
    String username;
    @Column(name = "token")
    String token;

}
