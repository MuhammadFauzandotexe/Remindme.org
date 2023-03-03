package Model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity()
@Table(name = "user_registered")
public class UserRegistered extends PanacheEntityBase {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    @Column(name = "email")
    String email;
    @Column(name = "username")
    String username;
    @Column(name = "token")
    String token;

}
