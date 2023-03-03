package AAAA_Pelatihaan;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity(name = "fruit")
public class Fruit extends PanacheEntityBase {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    @Column
    public String description;
    @Column
    public String name;
    public enum status{
        tersedia,tidakTersedia
    }
}
