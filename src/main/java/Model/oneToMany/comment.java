package Model.oneToMany;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
@Entity
@Table(name = "comment")
public class comment extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String body;
}
