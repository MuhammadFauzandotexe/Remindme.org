package databaseResource;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "task_name")
    public String taskName;
    @Column(name = "task")
    public String task;
    @Column(name = "date")
    public java.sql.Date date;
    @Column(name = "time")
    public java.sql.Time time;
}
