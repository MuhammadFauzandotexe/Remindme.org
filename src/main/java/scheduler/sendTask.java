package scheduler;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import javax.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class sendTask {
    @Scheduled(every = "10s")
    public void everySecond(){
        Integer hours = java.time.LocalTime.now().getHour();
        Integer minute = java.time.LocalTime.now().getMinute();
        Integer dayOfMonth = java.time.LocalDate.now().getDayOfMonth();
        Integer month = java.time.LocalDate.now().getMonthValue();

        String date = "2023-02-28";
        String time = "21:22:00";
        Connection connectionSelect;
        Connection connectionDelete;
        List<String> id= new ArrayList<>();
        List<String> task = new ArrayList<>();
        List<String> taskName = new ArrayList<>();
        try {
            String statement = "SELECT * FROM user_data where date='"+date+"' and time='"+time+"' order by id asc limit 1";
            connectionSelect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
            PreparedStatement preparedStatement = connectionSelect.prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                id.add(resultSet.getString("id"));
                task.add(resultSet.getString("task"));
                taskName.add(resultSet.getString("task_name"));
            }
            if(!id.isEmpty()){
                String statement2 = "DELETE FROM user_data WHERE id = "+id.get(0);
                connectionDelete = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawahedukasi","postgres","1");
                PreparedStatement preparedStatement1 = connectionDelete.prepareStatement(statement2);
                System.out.println(preparedStatement1.executeUpdate());
            }else {Log.info("no task");}
        }catch (Exception e){e.printStackTrace();}
        Log.info(id+":"+taskName+":"+task);
    }
}
