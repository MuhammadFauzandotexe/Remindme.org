package Model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "user_registration")
public class Register extends PanacheEntityBase {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    @Column(name = "email_registration",length = 50,unique = false,nullable = true)
    public String email;
    @Column(name = "name_registration",length = 50,nullable = true)
    public String name;
    @Column(name = "password_registration",unique = false,nullable = true)
    public String password;
    @Column(name = "token",unique = false,nullable = true)
    public String key_value;
    @Column(name = "key_value_encode",nullable = true)
    public String keyValueEncode;
}
