package Model.oneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "article")
public class Article extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String tittle;
    public String body;
    @OneToMany
    @JoinColumn(name = "article_id",referencedColumnName = "id")
    //@OneToMany(mappedBy = "article")
    public List<comment> comments;
}
