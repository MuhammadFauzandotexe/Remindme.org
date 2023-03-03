package Model;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData extends PanacheEntityBase {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    @Column(name = "email")
    public String email;
    @Column(name = "username")
    public String username;
    @Column(name = "task_name")
    public String taskName;
    @Column(name = "task")
    public String task;
    @Column(name = "date")
    public java.sql.Date date;
    @Column(name = "time")
    public java.sql.Time time;
}
